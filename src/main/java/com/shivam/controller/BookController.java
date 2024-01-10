package com.shivam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.entities.Book;
import com.shivam.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// Get all book handler :
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}
	
	// Get single book by ID handler :
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable int id) {
		return this.bookService.getBookById(id);
	}
	
	// Post single book handler :
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}
	
	// Delete book handler :
	@DeleteMapping("/books/{id}")
	public void deleteBookById(@PathVariable int id) {
		this.bookService.deleteBook(id);
	}
	
	// Update book handler :
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book , @PathVariable int bookId) {
		this.bookService.updateBook(book,bookId);
		return book;
	}
	
}
