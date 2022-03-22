package com.book.BookStore.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.BookStore.entity.BookEntity;
import com.book.BookStore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	private static Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody BookEntity book) throws JSONException {
		JSONObject response = new JSONObject();
		logger.info("addbook >> Started>> Request>> "+book.toString());
		try {
			BookEntity bookEntity = bookService.addBook(book);
			response.put("status","success");
			response.put("message", "Book added successfully");
			response.put("BookEntity", bookEntity);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("message", "Internal Server Error");
		}		
		logger.info("addbook >> Ended>> Response >>"+ response.toString());
		return response.toString();
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@RequestBody BookEntity book,@RequestParam("bookId") Long bookId) throws JSONException {
		JSONObject response = new JSONObject();
		logger.info("updateBook >> Started>> Request>> "+book.toString());
		try {
			BookEntity bookEntity = bookService.updateBook(book,bookId);
			response.put("status","success");
			response.put("message", "Book updated successfully");
			response.put("BookEntity", bookEntity.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("message", "Internal Server Error");
		}		
		logger.info("updateBook >> Ended>> Response >>"+ response.toString());
		return response.toString();
	}
	
	@PostMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") Long bookId) throws JSONException {
		JSONObject response = new JSONObject();
		logger.info("deleteBook >> Started>> Request>> "+bookId);
		try {
			bookService.deleteBook(bookId);
			response.put("status","success");
			response.put("message", "Book deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("message", "Internal Server Error");
		}		
		logger.info("deleteBook >> Ended>> Response >>"+ response.toString());
		return response.toString();
	}
	
	@GetMapping("/getAllBooks")
	public String getAllBooks() throws JSONException {
		JSONObject response = new JSONObject();
		logger.info("getAllBooks >> Started>> ");
		try {
			List<BookEntity> bookList = bookService.getAllBooks();
			response.put("status","success");
			response.put("message", "Book details list getting successfully");
			response.put("BookList", bookList);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("message", "Internal Server Error");
		}		
		logger.info("getAllBooks >> Ended>> Response >>"+ response.toString());
		return response.toString();
	}
	
	@GetMapping("/getBookById")
	public String getBookById(@RequestParam("bookId") Long bookId) throws JSONException {
		JSONObject response = new JSONObject();
		logger.info("getBookById >> Started>> bookId >> "+bookId);
		try {
			BookEntity book = bookService.getBookById(bookId);
			response.put("status","success");
			response.put("message", "Book details getting successfully");
			response.put("BookList", book.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", "failure");
			response.put("message", "Internal Server Error");
		}		
		logger.info("getBookById >> Ended>> Response >>"+ response.toString());
		return response.toString();
	}
}
