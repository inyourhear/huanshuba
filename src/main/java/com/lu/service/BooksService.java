package com.lu.service;

import com.lu.pojo.Books;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {

    ResponseEntity<?> addBooks(Books books);

    List<Books> queryBookByPage(int page_num);

    List<Books> queryBookByTitle(String book_title, int page_num);

    String deleteBookById(int book_id);

    Books queryBookDetailById(int book_id);

    List<Books> queryMyBookById(int user_id, int page_num);

    List<Books> queryBooksBySubject(String subject, int page_num);


}
