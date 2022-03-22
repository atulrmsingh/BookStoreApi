package com.book.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book.BookStore.dao.BookRepository;
import com.book.BookStore.entity.BookEntity;

@Transactional
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepo;

	@Override
	public BookEntity addBook(BookEntity book) throws Exception {
		return bookRepo.save(book);
	}

	@Override
	public BookEntity updateBook(BookEntity book,Long bookId) throws Exception {
		BookEntity bookEntity = bookRepo.getById(bookId);
		bookEntity.setAuthor(book.getAuthor());
		bookEntity.setBookName(book.getBookName());
		bookEntity.setCategory(book.getCategory());
		bookEntity.setCreatedAt(book.getCreatedAt());
		bookEntity.setDescription(book.getDescription());
		bookEntity.setWriter(book.getWriter());
		return bookRepo.save(bookEntity);
	}

	@Override
	public void deleteBook(Long bookId) throws Exception {
		bookRepo.deleteById(bookId);
	}

	@Override
	public List<BookEntity> getAllBooks() throws Exception {
		List<BookEntity> bookList = bookRepo.findAll();
		return bookList;
	}

	@Override
	public BookEntity getBookById(Long bookId) throws Exception {
		BookEntity book = bookRepo.getById(bookId);
		return book;
	}
}
