package com.poc.retaildiscounts.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String buildingNumber;
    private String streetName;
    private String city;
    private String country;
}
