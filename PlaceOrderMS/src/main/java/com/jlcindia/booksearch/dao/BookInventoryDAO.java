package com.jlcindia.booksearch.dao;

import com.jlcindia.booksearch.entity.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInventoryDAO extends JpaRepository<BookInventory, Integer> {
}