package com.poc.retaildiscounts.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Customer extends User {

    private String customerName;
    private String mobileNumber;
    private LocalDate registrationDate;
    private Boolean discountEligible;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
