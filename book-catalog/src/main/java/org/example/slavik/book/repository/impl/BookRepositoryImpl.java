package org.example.slavik.book.repository.impl;

import org.example.slavik.book.model.Book;
import org.example.slavik.book.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();
    @Override
    public Book save(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if( books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return book;
            }
        }

        books.add(book);
        return book;
    }

    @Override
    public boolean deleteById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Book> findById(int id) {
        for (Book book : books) {
            if (book.getId() == id){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findByBookName(String name) {
        if (name == null || name.isBlank()) {
            return findAll();
        }
        String temp = name.toLowerCase(Locale.ROOT);
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getNameBook().toLowerCase(Locale.ROOT).contains(temp)) {
                result.add(book);
            }
        }
        return result;
    }
}
