package com.jlcindia.booksearch.service;

import com.jlcindia.booksearch.entity.*;

import java.util.List;

public interface OrderService {
    public void placeOrder(OrderInfo orderInfo) ;
    public List<Order> getOrdersByUserId(String userId);
}