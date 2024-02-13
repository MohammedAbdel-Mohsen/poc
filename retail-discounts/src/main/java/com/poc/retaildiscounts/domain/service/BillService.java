package com.poc.retaildiscounts.domain.service;

import com.poc.retaildiscounts.domain.model.dto.BillInfoDTO;
import com.poc.retaildiscounts.domain.model.entities.Order;
import org.springframework.stereotype.Service;

@Service
public interface BillService {

    BillInfoDTO getBill(Order order);
    Double calculateBill(Order order);
}
