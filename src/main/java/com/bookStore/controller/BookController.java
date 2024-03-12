package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.model.Book;
import com.bookStore.model.MyBooks;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookService;

@Controller
public class BookController 
{
	@Autowired
	private BookService bs;
	@Autowired
	private MyBookService MyBook;
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/book_reg")
	public String bookReg()
	{
		return "bookReg";
	}
	@GetMapping("/avail")
	public ModelAndView available()
	{
		List<Book> list=bs.getAll();
		return new ModelAndView("available","book",list) ;
	}
	@PostMapping("/insert")
	public String addBook(@ModelAttribute Book b)
	{
		bs.insert(b);
		return "redirect:/avail";
	}
	@GetMapping("/my_books")
	public String myBook(Model m)
	{
		List<MyBooks> list=MyBook.getAllMy();
		m.addAttribute("book",list);
		return"mybooks";
	}
	@RequestMapping("/my_list/{id}")
	public String myBookList(@PathVariable("id") int id)
	{
		Book b=bs.getId(id);
		MyBooks mb=new MyBooks(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		MyBook.saveMyBook(mb);
		return"redirect:/my_books";
	}
	@GetMapping("/deleteById{id}")
	public String del(@PathVariable("id")int id)
	{
		MyBook.deleteById(id);
		return"redirect:/my_books";
	}
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id")int id,Model m)
	{
		Book b=bs.getId(id);
		m.addAttribute("book",b);
		return"bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String delete(@PathVariable("id")int id)
	{
		bs.deleteBook(id);
		return "redirect:/avail";
	}

}
