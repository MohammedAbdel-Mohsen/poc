package com.poc.retaildiscounts.domain.service;

import com.poc.retaildiscounts.domain.model.dto.PlaceOrderDTO;
import com.poc.retaildiscounts.domain.model.entities.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Order placeOrder(PlaceOrderDTO placeOrderDTO);

}
