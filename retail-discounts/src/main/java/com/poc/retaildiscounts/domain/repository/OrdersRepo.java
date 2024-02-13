package com.poc.retaildiscounts.domain.repository;

import com.poc.retaildiscounts.domain.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Order,Integer> {
}
