package com.poc.retaildiscounts.domain.service;

import com.poc.retaildiscounts.domain.model.entities.Customer;
import com.poc.retaildiscounts.domain.model.entities.LineItem;
import com.poc.retaildiscounts.domain.model.entities.Order;
import com.poc.retaildiscounts.domain.model.entities.Product;
import com.poc.retaildiscounts.domain.model.enums.ProductCategory;
import com.poc.retaildiscounts.domain.model.enums.UserDiscount;
import com.poc.retaildiscounts.domain.model.enums.UserState;
import com.poc.retaildiscounts.domain.repository.UsersRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BillServiceImplTest {
    @Mock
    UsersRepo usersRepo;
    @InjectMocks
    private BillServiceImpl billServiceImpl;


    /**
     * Method under test: {@link BillServiceImpl#calculateBill(Order)}
     */
    @Test
    void testCalculateBill() {

        // Arrange
        // TODO: Populate arranged inputs
        Order order = new Order();

        // create product instances
        Product tomato = new Product();
        tomato.setProductCategory(ProductCategory.GROCERIES);
        tomato.setPrice(50.0);
        tomato.setProductName("Tomatoes");

        Product milk = new Product();
        milk.setProductCategory(ProductCategory.DAIRY);
        milk.setPrice(35.0);
        milk.setProductName("Milk");

        // create set of line items
        LineItem lineItem1 = new LineItem();
        lineItem1.setProduct(tomato);
        lineItem1.setQuantity(5);


        LineItem lineItem2 = new LineItem();
        lineItem2.setProduct(milk);
        lineItem2.setQuantity(3);

        Set<LineItem> lineItems = new HashSet<>();
        lineItems.add(lineItem1);
        lineItems.add(lineItem2);

        order.setLineItems(lineItems);

        // Create Customer instance
        Customer customer = new Customer();
        customer.setUserId(1);
        customer.setUserType(UserDiscount.CUSTOMER.name());
        customer.setRegistrationDate(LocalDate.of(2019, 1, 1));
        customer.setEmail("mohamed@outlook.com");
        customer.setCustomerName("Mohamed");
        customer.setState(UserState.ACTIVE);
        customer.setDiscountEligible(true);

        order.setUser(customer);

        when(usersRepo.getDiscountEligibility(customer.getUserId())).thenReturn(true);
        Double actualCalculateBillResult = this.billServiceImpl.calculateBill(order);
        // Assertions
        assertEquals(349.75, actualCalculateBillResult,"calculateBill result is as expected");

    }
}
