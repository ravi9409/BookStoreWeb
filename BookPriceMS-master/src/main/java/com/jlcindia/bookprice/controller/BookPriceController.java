package com.jlcindia.bookprice.controller;

import com.jlcindia.bookprice.entity.BookPrice;
import com.jlcindia.bookprice.service.BookPriceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@CrossOrigin
@RestController
public class BookPriceController {

    static Logger log = LoggerFactory.getLogger(BookPriceController.class);

    @Autowired
    BookPriceService bookPriceService;

    @GetMapping("/bookPrice/{bookId}")
    @ApiOperation(value = "getBookPrice", response = BookPrice.class, notes = "Gives BookPrice Object of given bookId")
    public BookPrice getBookPrice(@PathVariable Integer bookId) {
        log.info("BookPriceController -- getBookPrice()----");
        BookPrice bookPrice = bookPriceService.getBookPriceById(bookId);
        return bookPrice;
    }

    @GetMapping("/offerPrice/{bookId}")
    @ApiOperation(value = "getOfferPrice", response = double.class, notes = "Gives Offered Price of given bookId")
    public double getOfferedPrice(@PathVariable Integer bookId) {
        log.info("BookPriceController -- getOfferedPrice()----");
        double offeredPrice = bookPriceService.getOfferedPriceById(bookId);
        return offeredPrice;
    }

}
