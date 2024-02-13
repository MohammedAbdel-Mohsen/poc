package com.poc.retaildiscounts.domain.repository;

import com.poc.retaildiscounts.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<User,Integer> {

    @Query("select u.discountEligible from User u where u.id = ?1")
    public Boolean getDiscountEligibility(Integer userId);

}
