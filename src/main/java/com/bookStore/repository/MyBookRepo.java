package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.model.MyBooks;

@Repository
public interface MyBookRepo extends JpaRepository<MyBooks, Integer> {

}
