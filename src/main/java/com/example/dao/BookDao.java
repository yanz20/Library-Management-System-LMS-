package com.example.dao;

import java.util.List;

import com.example.model.*;

public interface BookDao {
	public List<Book> getAllBooks();
	
	public Book findBookByID(int id);
	
	public Book findBookByName(String name);
	
	public void addBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBook(int id);
	
}
