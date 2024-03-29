package com.pi.orderservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pi.orderservice.model.Order;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public Order addOrder(Order order) {
        orders.add(order);
        return order;
    }

    public Order findById(Long id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Order> findAll() {
        return orders;
    }

    public Order cancelOrder(Long id) {
        Order order = findById(id);
        order.cancel();
        return order;
    }

    public Order reviseOrder(Long id, Order order) {
        Order orderToRevise = findById(id);
        orderToRevise.revise(order);
        return orderToRevise;
    }

    
}
