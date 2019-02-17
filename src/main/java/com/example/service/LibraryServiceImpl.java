package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookDaoImpl;
import com.example.model.Book;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private BookDaoImpl bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book findBookByID(int id) {
		return bookDao.findBookByID(id);
	}

	@Override
	public Book findBookByName(String name) {
		return bookDao.findBookByName(name);
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
		
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
		
	}

}
