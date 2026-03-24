package org.example.slavik.book.service;

import org.example.slavik.book.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(String bookName, String authorName, int date);

    boolean deleteById(int id);

    List<Book> searchByBookName(String name);

    List<Book> findAll();

    String printBooks(Book book);
}
