package com.jlcindia.booksearch.dao;

import com.jlcindia.booksearch.entity.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingDAO extends JpaRepository<UserRating, Integer> {
    public List<UserRating> findUserRatingByBookId(Integer bookId);
    public List<UserRating> findUserRatingByUserId(String userId);
}
