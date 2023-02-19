package com.jlcindia.bookprice.service;

import com.jlcindia.bookprice.dao.BookPriceDAO;
import com.jlcindia.bookprice.entity.BookPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class BookPriceServiceImpl implements BookPriceService{

    static Logger log= LoggerFactory.getLogger(BookPriceServiceImpl.class);

    @Autowired
    BookPriceDAO bookPriceDAO;

    @Override
    public BookPrice getBookPriceById(Integer bookId) {
       log.info(" BookPriceServiceImpl getBookPriceById");
       BookPrice bookPrice=null;
       Optional<BookPrice> opt=bookPriceDAO.findById(bookId);
       if(opt.isPresent()){
           bookPrice=opt.get();
       }
       return bookPrice;
    }

    @Override
    public double getOfferedPriceById(Integer bookId) {
        log.info(" BookPriceServiceImpl getOfferedPriceById() ");
        double offerPrice=0.0;
        Optional<BookPrice> opt=bookPriceDAO.findById(bookId);
        if(opt.isPresent()){
            BookPrice bookPrice=opt.get();
            double price=bookPrice.getPrice();
            double offer=bookPrice.getOffer();
            if(offer<=0){
                return price;
            }

            offerPrice=price-price*offer/100;
        }
        return offerPrice;
    }
}
