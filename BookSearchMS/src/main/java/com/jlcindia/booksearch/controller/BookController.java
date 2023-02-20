package com.jlcindia.booksearch.controller;

import com.jlcindia.booksearch.entity.Book;
import com.jlcindia.booksearch.entity.BookInfo;
import com.jlcindia.booksearch.entity.BookInventory;
import com.jlcindia.booksearch.entity.BookRating;
import com.jlcindia.booksearch.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BookController {

    static Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @GetMapping("/mybooks/{author}/{category}")
    @ApiOperation(value = " getBooks", response = List.class, notes = "Returns List of Books for " +
            "given Author and Category")
    public List<Book> getBooks(@PathVariable String author, @PathVariable String category) {
        log.info("---BookController---getBooks()-----");
        System.out.println(author + "\t" + category);
        return bookService.getBooks(author, category);
    }

    @GetMapping("/mybook/{bookId}")
    @ApiOperation(value = " getBookById", response = BookInfo.class, notes = "Returns BookInfo for " +
            "given BID")
    public BookInfo getBookById(@PathVariable Integer bookId) {
        log.info("---BookController---getBookById()-----");
        return bookService.getBookInfo(bookId);
    }

    @PutMapping("/updateBookRating")
    @ApiOperation(value = " updateBookRating", response = void.class, notes =
            "updateBookRating")
    public void updateBookRating(@RequestBody BookRating bookRating) {
        System.out.println("-------BookController-----updateBookRating()-----");
        bookService.updateBookRating(bookRating);
    }

    @PutMapping("/updateBookInventory")
    @ApiOperation(value = " updateBookInventory", response = void.class, notes = "updateBookInventory")
    public void updateBookInventory(@RequestBody BookInventory bookInventory) {
        System.out.println("-------BookController-----updateBookInventory()-----");
        bookService.updateBookInventory(bookInventory);
    }
}