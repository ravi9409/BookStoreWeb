package com.jlcindia.booksearch.service;

import com.jlcindia.booksearch.entity.*;

import java.util.List;

public interface RatingService {
    public void addUserRating(UserRating userRating);
    public List<UserRating> getUserRatingByBookId(Integer bookId);
    public List<UserRating> getUserRatingByUserId(String userId);
    public BookRating getBookRatingByBookId(Integer bookId);
}