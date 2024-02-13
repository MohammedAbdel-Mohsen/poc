package com.poc.retaildiscounts.domain.model.dto;

import com.poc.retaildiscounts.domain.model.entities.LineItem;
import com.poc.retaildiscounts.domain.model.entities.User;

import java.util.Set;

public record PlaceOrderDTO(User user, Set<LineItem> items) {
}
