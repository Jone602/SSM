package com.feng.services;

import com.feng.dao.BookDao;
import com.feng.domain.Books;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    private BookDao bookDao;
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    public int addBook(Books books) {
        return bookDao.addBook(books);
    }

    public int deleteBook(int id) {
        return bookDao.deleteBook(id);
    }

    public int updateBook(Books books) {
        System.out.println("BooksServiceImpl books==>"+books);
        return bookDao.updateBook(books);
    }

    public Books getBookById(int id) {
        Books book = bookDao.getBookById(id);
        return book;
    }
    public List<Books> getBooksList() {
        List<Books> booksList = bookDao.getBooksList();
        return booksList;
    }

    public Books queryBookByName(String bookName) {
        return bookDao.queryBookByName(bookName);
    }
}
