package com.poc.retaildiscounts.domain.model.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Employee extends User{

    private String employeeName;
    private String title;
}
