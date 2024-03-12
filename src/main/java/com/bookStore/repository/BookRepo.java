package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
