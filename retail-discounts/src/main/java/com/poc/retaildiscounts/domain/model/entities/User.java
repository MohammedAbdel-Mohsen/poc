package com.poc.retaildiscounts.domain.model.entities;

import com.poc.retaildiscounts.domain.model.enums.UserState;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",discriminatorType = DiscriminatorType.STRING)
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    private String email;
    private String password;
    private UserState state;
    @Column(name="user_type", insertable = false, updatable = false)
    private String userType;
}
