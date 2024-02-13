package com.poc.retaildiscounts.infrastructure.runners;

import com.poc.retaildiscounts.domain.model.entities.*;
import com.poc.retaildiscounts.domain.model.enums.ProductCategory;
import com.poc.retaildiscounts.domain.model.enums.UserState;
import com.poc.retaildiscounts.domain.repository.OrdersRepo;
import com.poc.retaildiscounts.domain.repository.ProductsRepo;
import com.poc.retaildiscounts.domain.repository.UsersRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
@AllArgsConstructor
public class DBRunner implements CommandLineRunner {

    private ProductsRepo productsRepo;
    private UsersRepo usersRepo;
    private OrdersRepo ordersRepo;


    @Override
    public void run(String... args) throws Exception {

        // Preparing Master Data
        createUsers();
        createProducts();

    }

    public void createUsers() {

        List<User> usersList = new ArrayList<>();

        // adding old customer who have registered at retail since over 2 years
        Customer oldCustomer = new Customer();
        oldCustomer.setCustomerName("Mohammed Elnwam");
        oldCustomer.setMobileNumber("01033232060");
        oldCustomer.setEmail("mohamed_elnwam@outlook.com");
        oldCustomer.setPassword("xyz");
        oldCustomer.setState(UserState.ACTIVE);
        oldCustomer.setRegistrationDate(LocalDate.of(2021, 1, 20));
        oldCustomer.setAddress(createAddress());
        usersList.add(oldCustomer);

        // adding new customer who have recently registered at retail
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("Ahmed Elnwam");
        newCustomer.setMobileNumber("01033232060");
        newCustomer.setEmail("ahmed_elnwam@outlook.com");
        newCustomer.setPassword("ops");
        newCustomer.setState(UserState.NEW);
        newCustomer.setRegistrationDate(LocalDate.of(2023, 1, 20));
        newCustomer.setAddress(createAddress());
        usersList.add(newCustomer);

        // adding employee
        Employee employee = new Employee();
        employee.setEmployeeName("Mahmoud Mohamed");
        employee.setState(UserState.ACTIVE);
        employee.setEmail("mahmoud@outlook.com");
        employee.setTitle("Supervisor");
        employee.setPassword("xxv");
        usersList.add(employee);

        Affiliate affiliate = new Affiliate();
        affiliate.setAffiliateName("Aman Store");
        affiliate.setEmail("aman@org.eg");
        affiliate.setPassword("aman-org");
        affiliate.setState(UserState.ACTIVE);
        usersList.add(affiliate);


        log.info(">>>>>> Start Saving Customers");
        usersRepo.saveAll(usersList);
        log.info(">>>>>> End Saving Customers");

    }

    public Address createAddress() {
        Address address = new Address();
        address.setCity("Giza");
        address.setCountry("Egypt");
        address.setStreetName("Sheikh Zayed");
        address.setBuildingNumber("101");
        return address;
    }

    public void createProducts(){

        List<Product>products=new ArrayList<>();

        Product groceryProduct=new Product();
        groceryProduct.setProductCategory(ProductCategory.GROCERIES);
        groceryProduct.setProductName("cucumber");
        groceryProduct.setPrice(10.0);
        products.add(groceryProduct);

        Product dairyProduct=new Product();
        dairyProduct.setProductName("milk");
        dairyProduct.setPrice(15.0);
        dairyProduct.setProductCategory(ProductCategory.DAIRY);
        products.add(dairyProduct);

        Product bakeryProduct=new Product();
        bakeryProduct.setProductName("bread");
        bakeryProduct.setPrice(25.0);
        bakeryProduct.setProductCategory(ProductCategory.BAKERY);
        products.add(dairyProduct);

        log.info(">>>>>> Start Saving Products");
        productsRepo.saveAll(products);
        log.info(">>>>>> End Saving Products");

    }

    public Order placeOrder(User user, Set<LineItem> items){

        Order order=new Order();
        order.setUser(user);
        order.setLineItems(items);

        return order;
    }



}
