package com.jlcindia.booksearch.service;

import com.jlcindia.booksearch.entity.*;

import java.util.List;

public interface BookService {
    public List<Book> getBooks(String author, String category);
    public BookInfo getBookInfo(Integer bookId);
    public void updateBookRating(BookRating bookRating);
    public void updateBookInventory(BookInventory bookInventory);
}