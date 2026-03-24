package org.example.slavik.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
    private final int id;
    private final String authorName;
    private final String nameBook;
    private final int year;

    public Book(int id, String authorName, String nameBook, int year) {
        if (nameBook == null || nameBook.isBlank()) {
            throw new IllegalArgumentException("Имя книги не может быть пустым");
        }
        if (authorName == null || authorName.isBlank()) {
            throw new IllegalArgumentException("Имя автора не может быть пустым");
        }
        this.id = id;
        this.authorName = authorName;
        this.nameBook = nameBook;
        this.year = year;
    }
}
