package org.example.slavik;

import org.example.slavik.book.model.Book;
import org.example.slavik.book.repository.impl.BookRepositoryImpl;
import org.example.slavik.book.repository.BookRepository;
import org.example.slavik.book.service.impl.BookServiceImpl;
import org.example.slavik.book.service.BookService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookServiceImpl(bookRepository);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println();
                System.out.println("Каталог книг");
                System.out.println("1) Добавить книгу");
                System.out.println("2) Показать все книги");
                System.out.println("3) Поиск по названию");
                System.out.println("4) Удалить по id");
                System.out.println("0) Выход");
                System.out.print("Выбор: ");
                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1" -> {
                        System.out.print("Название: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Автор: ");
                        String author = scanner.nextLine().trim();
                        System.out.print("Год: ");
                        int year;
                        try {
                            year = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Год должен быть числом.");
                            break;
                        }
                        try {
                            Book created = bookService.addBook(title, author, year);
                            System.out.println("Добавлено: " + created);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    }
                    case "2" -> {
                        List<Book> books = bookService.findAll();
                        if (books.isEmpty()) {
                            System.out.println("Каталог пуст.");
                        } else {
                            for (Book book : books) {
                                System.out.println(bookService.printBooks(book));
                            }
                        }
                    }
                    case "3" -> {
                        System.out.print("Введите часть названия: ");
                        String query = scanner.nextLine().trim();
                        List<Book> found = bookService.searchByBookName(query);
                        if (found.isEmpty()) {
                            System.out.println("Ничего не найдено.");
                        } else {
                            for (Book book : found) {
                                System.out.println(book);
                            }
                        }
                    }
                    case "4" -> {
                        System.out.print("Введите id: ");
                        int id;
                        try {
                            id = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("id должен быть числом.");
                            break;
                        }
                        boolean removed = bookService.deleteById(id);
                        if (removed) {
                            System.out.println("Удалено.");
                        } else {
                            System.out.println("Книга с таким id не найдена.");
                        }
                    }
                    case "0" -> {
                        System.out.println("Выход.");
                        return;
                    }
                    default -> System.out.println("Неизвестная команда: " + choice);
                }
            }
        }
    }
}
