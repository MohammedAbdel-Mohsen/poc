package com.poc.retaildiscounts.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private Set<LineItem> lineItems = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private Bill bill;

}
