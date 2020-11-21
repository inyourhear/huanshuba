package com.lu.service;

import com.lu.mapper.BooksMapper;
import com.lu.pojo.Books;
import com.lu.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("BooksServiceImpl")
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;


    // ==================================================
    // Create
    public ResponseEntity<?> addBooks(Books books) {
        if(this.queryBookDetailById(books.getBook_id()) == null){
            booksMapper.addBooks(books);
            return new ResponseEntity<String>("Successful", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Error",HttpStatus.BAD_REQUEST);
        }
    }


    // ==================================================
    // Read
    public List<Books> queryBookByPage(int page_num) {
        List<Books> booksList = booksMapper.queryAllBooks();

        List<List<Books>> listSplit = new ArrayList<>();

        listSplit = CommonUtil.splitList(booksList, 10);

        if (page_num < listSplit.size() && page_num > -1)
            return listSplit.get(page_num);
        else
            return null;
    }

    public List<Books> queryBookByTitle(String book_title, int page_num) {
        // could perform sql check here
        // like sqlsafe(book_title);
        boolean safe = true;
        if(safe) {
            List<Books> booksList = booksMapper.queryBooksByTitle(book_title);

            List<List<Books>> listSplit = new ArrayList<>();

            listSplit = CommonUtil.splitList(booksList, 10);
            System.out.println(listSplit.size());
            if (page_num < listSplit.size() && page_num > -1)
                return listSplit.get(page_num);
            else
                return null;
        }
        else
            return null;
    }

    public Books queryBookDetailById(int book_id){
        if (book_id > 0){
            return booksMapper.queryBookDetailById(book_id);
        }else {
            return null;
        }
    }

    public List<Books> queryMyBookById(int user_id, int page_num){
        if (user_id > 0){
            if (booksMapper.queryMyBookById(user_id).size() > 0){
                List<Books> booksList = booksMapper.queryMyBookById(user_id);
                List<List<Books>> listSplit = new ArrayList<>();
                listSplit = CommonUtil.splitList(booksList, 10);
                if (page_num < listSplit.size() && page_num > -1){
                    return listSplit.get(page_num);
                }else {
                    return null;
                }
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    public List<Books> queryBooksBySubject(String subject, int page_num) {
        if (subject.equals("文科") || subject.equals("理科") || subject.equals("工科")){

            List<Books> booksList = booksMapper.queryBooksBySubject(subject);

            List<List<Books>> listSplit = new ArrayList<>();

            listSplit = CommonUtil.splitList(booksList, 10);

            if (page_num < listSplit.size() && page_num > -1){
                return listSplit.get(page_num);
            }else {
                return null;
            }
        }else {
            return null;
        }
    }


    // ==================================================
    // Delete
    public String deleteBookById(int book_id) {
        // situations:
        // 1. normal
        // 2. no such object
        int result = booksMapper.deleteBookById(book_id);

        return result==0?"successful":"failed";
    }

}
