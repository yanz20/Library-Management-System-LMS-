package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException{
		Book book = new Book();
		book.setBookID(rs.getInt("bookID"));
		book.setBookname(rs.getString("bookname"));
		book.setPublisher(rs.getString("publisher"));
		book.setAuthor(rs.getString("author"));
		book.setIssued(rs.getBoolean("isIssued"));
		return book;
	}

}
