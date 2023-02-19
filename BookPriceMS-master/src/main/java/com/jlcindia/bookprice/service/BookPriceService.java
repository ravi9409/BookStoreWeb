package com.jlcindia.bookprice.service;

import com.jlcindia.bookprice.entity.BookPrice;

public interface BookPriceService {
    public BookPrice getBookPriceById(Integer bookId);
    public double getOfferedPriceById(Integer bookId);
}