package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Book;
import com.example.service.LibraryServiceImpl;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private LibraryServiceImpl libraryService;
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public ModelAndView getAllBooks() {
		ModelAndView model = new ModelAndView();
		List<Book> list = libraryService.getAllBooks();
		
		model.addObject("book_list", list);
		model.setViewName("book_list");
		return model;
	}
	
	@RequestMapping(value="/updateid/{id}", method=RequestMethod.GET)
	public ModelAndView editBookByID(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		
		Book book = libraryService.findBookByID(id);
		model.addObject("bookForm", book);
		model.setViewName("book_form");
		return model;
	}
	
	@RequestMapping(value="/updatename/{name}", method=RequestMethod.GET)
	public ModelAndView editBookByName(@PathVariable String name) {
		ModelAndView model = new ModelAndView();
		
		Book book = libraryService.findBookByName(name);
		model.addObject("bookForm", book);
		
		model.setViewName("bookForm");
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addBook() {
		ModelAndView model = new ModelAndView();
		
		Book book = new Book();
		model.addObject("bookForm", book);
		
		model.setViewName("book_form");
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("bookForm") Book book) {
		libraryService.addBook(book);
		
		return new ModelAndView("redirect:/book/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteBook(@PathVariable("id") int id) {
		libraryService.deleteBook(id);
		return new ModelAndView("redirect:/book/list");
	}
}
