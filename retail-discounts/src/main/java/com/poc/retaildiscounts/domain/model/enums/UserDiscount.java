package com.poc.retaildiscounts.domain.model.enums;

import lombok.Getter;

@Getter
public enum UserDiscount {
    CUSTOMER(0.05),
    EMPLOYEE(0.30),
    AFFILIATE(0.10);

    private final double discount;
    UserDiscount(double discount) {
        this.discount=discount;
    }

}
