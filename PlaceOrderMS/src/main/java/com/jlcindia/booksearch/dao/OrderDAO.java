package com.jlcindia.booksearch.dao;

import com.jlcindia.booksearch.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {
    public List<Order> findOrderByUserId(String userId);
}