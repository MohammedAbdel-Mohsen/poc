package com.poc.retaildiscounts.domain.service;

import com.poc.retaildiscounts.domain.model.dto.BillInfoDTO;
import com.poc.retaildiscounts.domain.model.entities.LineItem;
import com.poc.retaildiscounts.domain.model.entities.Order;
import com.poc.retaildiscounts.domain.model.entities.User;
import com.poc.retaildiscounts.domain.model.enums.ProductCategory;
import com.poc.retaildiscounts.domain.model.enums.UserDiscount;
import com.poc.retaildiscounts.domain.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@Primary
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    UsersRepo usersRepo;

    @Override
    public BillInfoDTO getBill(Order order) {
        Double netPaymentAmount = calculateBill(order);
        return new BillInfoDTO(order.getUser().getEmail(), netPaymentAmount);
    }

    @Override
    public Double calculateBill(Order order) {

        double discount = 0;
        double totalAmount = 0;
        User user = order.getUser();
        String userType = user.getUserType();
        Set<LineItem> items = order.getLineItems();

        switch (userType) {
            case "CUSTOMER":
                Boolean discountEligible = usersRepo.getDiscountEligibility(user.getUserId());
                if (Boolean.TRUE.equals(discountEligible)) {
                    discount = UserDiscount.CUSTOMER.getDiscount();
                }
                break;
            case "AFFILIATE":
                discount = UserDiscount.AFFILIATE.getDiscount();
                break;
            case "EMPLOYEE":
                discount = UserDiscount.EMPLOYEE.getDiscount();
                break;
            default:
                break;
        }

        Set<LineItem> groceryItems = items.stream().filter(s -> s.getProduct().getProductCategory().equals(ProductCategory.GROCERIES)).collect(Collectors.toSet());
        Set<LineItem> nonGroceryItems = items.stream().filter(s -> !s.getProduct().getProductCategory().equals(ProductCategory.GROCERIES)).collect(Collectors.toSet());

        if (!groceryItems.isEmpty() && !nonGroceryItems.isEmpty()) {

            for (LineItem item : nonGroceryItems) {
                totalAmount += (item.getProduct().getPrice() * item.getQuantity() * (1 - discount));
            }

            for (LineItem item : groceryItems) {
                totalAmount += (item.getProduct().getPrice() * item.getQuantity());
            }
        } else if (!groceryItems.isEmpty()) {
            for (LineItem item : groceryItems) {
                totalAmount += (item.getProduct().getPrice() * item.getQuantity());
            }

            totalAmount = totalAmount - ((Math.floor(totalAmount / 100)) * 5);
        } else {
            for (LineItem item : nonGroceryItems) {
                totalAmount += (item.getProduct().getPrice() * item.getQuantity() * (1 - discount));
            }
        }


        return totalAmount;
    }
}
