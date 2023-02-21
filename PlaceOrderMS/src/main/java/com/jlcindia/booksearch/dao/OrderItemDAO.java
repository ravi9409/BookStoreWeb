package com.jlcindia.booksearch.dao;

import com.jlcindia.booksearch.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findOrderItemsByOrderId(Integer orderId);
}
