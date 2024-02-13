package com.poc.retaildiscounts.domain.repository;

import com.poc.retaildiscounts.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Product,Integer> {
}
