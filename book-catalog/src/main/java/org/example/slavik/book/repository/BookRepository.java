package org.example.slavik.book.repository;

import org.example.slavik.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);

    boolean deleteById(int id);

    List<Book> findAll();

    List<Book> findByBookName(String name);

    Optional<Book> findById(int id);
}
