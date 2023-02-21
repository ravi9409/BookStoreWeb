package com.jlcindia.booksearch.service;

import com.jlcindia.booksearch.dao.BookInventoryDAO;
import com.jlcindia.booksearch.dao.OrderDAO;
import com.jlcindia.booksearch.dao.OrderItemDAO;
import com.jlcindia.booksearch.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    static Logger log= LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderItemDAO orderItemDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    BookInventoryDAO bookInventoryDAO;

    @Override
    public void placeOrder(OrderInfo orderInfo) {
        log.info(" OrderServiceImpl placeOrder() ");
        Order myorder=orderInfo.getOrder();
        myorder=orderDAO.save(myorder);
        int orderId=myorder.getOrderId();

        for(OrderItem myitem:orderInfo.getItemsList()) {
            myitem.setOrderId(orderId);
            orderItemDAO.save(myitem);
        }

        RestTemplate bookSearchRest=new RestTemplate();
        String endpoint="http://localhost:8000/updateBookInventory";
        for (OrderItem myitem:orderInfo.getItemsList()){
            Integer bookId=myitem.getBookId();
            BookInventory bookInventory=bookInventoryDAO.findById(bookId).get();
            bookInventory.setBooksAvailable(bookInventory.getBooksAvailable()-1);
            bookInventoryDAO.save(bookInventory);
            bookSearchRest.put(endpoint,bookInventory);
        }
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        log.info("---OrderServiceImpl---getOrdersByUserId()-----");
        List<Order> orderList= orderDAO.findOrderByUserId(userId);
        return orderList;
    }
}
