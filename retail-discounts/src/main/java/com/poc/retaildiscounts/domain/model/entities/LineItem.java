package com.poc.retaildiscounts.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;
}
