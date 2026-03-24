package org.example.slavik.book.service.impl;

import org.example.slavik.book.model.Book;
import org.example.slavik.book.repository.BookRepository;
import org.example.slavik.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private int nextId = 1;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(String bookName, String authorName, int date) {
        Book book = new Book(nextId++, bookName, authorName, date);
        bookRepository.save(book);
        return book;
    }

    @Override
    public boolean deleteById(int id) {
        return bookRepository.deleteById(id);
    }

    @Override
    public List<Book> searchByBookName(String name) {
        return bookRepository.findByBookName(name);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public String printBooks(Book book) {
        return  "Название книги: " + book.getNameBook() +
                " \nИмя автора: " + book.getAuthorName() +
                " \nГод издания: " + book.getYear() + "\n";
    }
}
