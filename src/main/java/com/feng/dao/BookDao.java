package com.feng.dao;

import com.feng.domain.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    int addBook(Books books);

    int deleteBook(@Param("bookId") int id);

    int updateBook(Books books);

    Books getBookById(@Param("bookId") int id);

    List<Books> getBooksList();
}
