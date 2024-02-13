package com.poc.retaildiscounts.domain.repository;

import com.poc.retaildiscounts.domain.model.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsRepo extends JpaRepository<Bill,Integer> {
}
