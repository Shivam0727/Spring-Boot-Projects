package com.shivam.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shivam.entities.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();
	static {
		list.add(new Book(1,"Java Complete reference","James"));
		list.add(new Book(2,"Head First Java","Goslin"));
		list.add(new Book(3,"Learn Fundamental of frameworks","Johnson"));
	}
	
	// Get all Books :
	public List<Book> getAllBooks() {
		return list;
	}
	
	// Get single Book by ID :
	public Book getBookById(int id) {
		Book book = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	// Adding the book :
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

	// Delete book :
	public void deleteBook(int id) {
		list = list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
	}
	
	// Updating book :
	public void updateBook(Book book, int bookId) {
		list = list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		
	}
}
