package com.lu.mapper;

import com.lu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {

    int addBooks(Books books);

    int deleteBookById(@Param("book_id") int book_id);

    List<Books> queryBooksByTitle(@Param("book_title") String book_title);

    List<Books> queryAllBooks();

    Books queryBookDetailById(@Param("book_id") int book_id);

    List<Books> queryMyBookById(@Param("user_id") int user_id);

    List<Books> queryBooksBySubject(@Param("subject") String subject);





}
