package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.model.Book;
import com.bookStore.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo br;

	public void insert(Book b) {
		br.save(b);
	}

	public List<Book> getAll() {
		return br.findAll();
	}

	public Book getId(int id) {
		return br.findById(id).get();
	}

	public void deleteBook(int id) {
		br.deleteById(id);
	}

}
