package com.feng.services;

import com.feng.domain.Books;

import java.util.List;

public interface BooksService {
    int addBook(Books books);

    int deleteBook(int id);

    int updateBook(Books books);

    Books getBookById(int id);

    List<Books> getBooksList();
    Books queryBookByName(String bookName);
}
