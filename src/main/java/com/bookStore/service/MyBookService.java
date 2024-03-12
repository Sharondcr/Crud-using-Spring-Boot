package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.model.MyBooks;
import com.bookStore.repository.MyBookRepo;

@Service
public class MyBookService {
	@Autowired
	private MyBookRepo mb;

	public void saveMyBook(MyBooks m) {
		mb.save(m);
	}

	public List<MyBooks> getAllMy() {
		return mb.findAll();
	}

	public void deleteById(int id) {
		mb.deleteById(id);
	}

}
