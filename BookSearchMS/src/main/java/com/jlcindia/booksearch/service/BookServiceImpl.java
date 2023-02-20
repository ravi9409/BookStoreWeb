package com.jlcindia.booksearch.service;

import com.jlcindia.booksearch.dao.BookDAO;
import com.jlcindia.booksearch.dao.BookInventoryDAO;
import com.jlcindia.booksearch.dao.BookRatingDAO;
import com.jlcindia.booksearch.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    static Logger log= LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookInventoryDAO bookInventoryDAO;

    @Autowired
    BookRatingDAO bookRatingDAO;

    @Autowired
    BookDAO bookDAO;

    @Override
    public List<Book> getBooks(String author, String category) {
        List<Book> mybooks=new ArrayList<>();
        if(author.equals("All Authors") && category.equals("All Categories")){
            mybooks=bookDAO.findAll();
        }else if(author.equals("All Authors") && !category.equals("All Categories")){
            mybooks=bookDAO.getBooksByCategory(category);
        }else if(!author.equals("All Authors") && category.equals("All Categories")){
            mybooks=bookDAO.getBooksByAuthor(author);
        }else{
            mybooks=bookDAO.getBooksByAuthorAndCategory(author,category);
        }
        return mybooks;
    }

    @Override
    public BookInfo getBookInfo(Integer bookId) {
        BookInfo bookInfo=new BookInfo();
        Book book=bookDAO.findById(bookId).get();
        bookInfo.setBookId(book.getBookId());
        bookInfo.setBookName(book.getBookName());
        bookInfo.setAuthor(book.getAuthor());
        bookInfo.setPublications(book.getPublications());
        bookInfo.setCategory(book.getCategory());

        BookRating bookRating=bookRatingDAO.findById(bookId).get();
        bookInfo.setAvgRating(bookRating.getAvgRating());//6
        bookInfo.setNumberOfSearches(bookRating.getNumberOfSearches());//7

        BookInventory bookInventory=bookInventoryDAO.findById(bookId).get();
        bookInfo.setBooksAvailable(bookInventory.getBooksAvailable());//8

        RestTemplate bookPriceRest=new RestTemplate();
        String endpoint="http://localhost:9000/bookPrice/"+bookId;
        BookPriceInfo bookPriceInfo=bookPriceRest.getForObject(endpoint,BookPriceInfo.class);
        bookInfo.setPrice(bookPriceInfo.getPrice());
        bookInfo.setOffer(bookPriceInfo.getOffer());

        return bookInfo;
    }

    @Override
    public void updateBookRating(BookRating bookRating) {
        bookRatingDAO.save(bookRating);
    }

    @Override
    public void updateBookInventory(BookInventory bookInventory) {
        bookInventoryDAO.save(bookInventory);
    }
}
