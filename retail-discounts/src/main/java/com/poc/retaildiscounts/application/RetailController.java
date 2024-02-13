package com.poc.retaildiscounts.application;

import com.poc.retaildiscounts.domain.model.dto.BillInfoDTO;
import com.poc.retaildiscounts.domain.model.dto.PlaceOrderDTO;
import com.poc.retaildiscounts.domain.model.entities.Order;
import com.poc.retaildiscounts.domain.service.BillService;
import com.poc.retaildiscounts.domain.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/services")
@AllArgsConstructor
public class RetailController {

    OrderService orderService;
    BillService billService;


    @PostMapping(path = "/bill-info")
    public ResponseEntity<BillInfoDTO> proceedPayment(@RequestBody PlaceOrderDTO placeOrderDTO){

        Order order=orderService.placeOrder(placeOrderDTO);
        BillInfoDTO billInfoDTO=billService.getBill(order);
        return (ResponseEntity.ok()).body(billInfoDTO);
    }

}
