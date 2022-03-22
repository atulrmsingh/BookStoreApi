package com.book.BookStore.service;

import java.util.List;

import com.book.BookStore.entity.BookEntity;

public interface BookService {

	public BookEntity addBook(BookEntity book) throws Exception;

	public BookEntity updateBook(BookEntity book,Long bookId) throws Exception;

	public void deleteBook(Long bookId) throws Exception;

	public List<BookEntity> getAllBooks() throws Exception;

	public BookEntity getBookById(Long bookId) throws Exception;

	
}
