package com.poc.retaildiscounts.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;
    private Double totalAmount;
    private Double discount;
    private Double netAmount;
    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;
}
