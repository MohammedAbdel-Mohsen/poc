package com.poc.retaildiscounts.domain.model.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Affiliate extends User{

    private String affiliateName;
}
