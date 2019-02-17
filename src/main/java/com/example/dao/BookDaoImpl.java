package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Book;
import com.example.model.BookRowMapper;;

@Transactional
@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> getAllBooks() {
		String query = "SELECT * FROM Books";
		RowMapper<Book> rowMapper = new BookRowMapper();
		List<Book> list = jdbcTemplate.query(query, rowMapper);
		return list;
	}

	@Override
	public Book findBookByID(int id) {
		String query = "SELECT * FROM Books WHERE bookID = ?";
		RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
		Book book = jdbcTemplate.queryForObject(query, rowMapper, id);
		
		return book;
	}

	@Override
	public Book findBookByName(String name) {
		String query = "SELECT * FROM Books WHERE bookname = ?";
		RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
		Book book = jdbcTemplate.queryForObject(query, rowMapper, name);
		
		return book;
	}

	@Override
	public void addBook(Book book) {
		String query = "INSERT INTO Books(bookID, bookname, publisher,author, isIssued) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(query, book.getBookID(), book.getBookname(), book.getPublisher(), book.getAuthor(), book.isIssued());
		
	}

	@Override
	public void updateBook(Book book) {
		String query = "UPDATE Books SET bookID=?, bookname=?, publisher=?,author=?, isIssued=?";
		jdbcTemplate.update(query, book.getBookID(), book.getBookname(), book.getPublisher(), book.getAuthor(), book.isIssued());
		
	}

	@Override
	public void deleteBook(int id) {
		String query = "DELETE FROM Books WHERE bookID=?";
		jdbcTemplate.update(query, id);
		
	}
	
}
