package com.lu.controller;

import com.lu.pojo.Books;
import com.lu.service.BooksService;
import com.lu.utils.Uploads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {

    @Autowired
    private BooksService booksService;

    // ======================================================
    // Create - POST
    @PostMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        Uploads uploads = new Uploads();
        return uploads.uploadImg(file, request);
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody Books books, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors())
            return new ResponseEntity<String>("Binding Error", HttpStatus.BAD_REQUEST);
        else
            return booksService.addBooks(books);
    }

    // ======================================================
    // Read - GET
    @GetMapping("/search/{title}/{page_num}")
    public ResponseEntity<?> search(@PathVariable String title, @PathVariable int page_num) throws Exception {
        return new ResponseEntity<List<Books>>(booksService.queryBookByTitle(title, page_num), HttpStatus.OK);
    }

    @GetMapping("/page/{page_num}")
    public ResponseEntity<?> queryAll(@PathVariable int page_num) throws Exception {
        return new ResponseEntity<List<Books>>(booksService.queryBookByPage(page_num), HttpStatus.OK);
    }

    @GetMapping("/detail/{book_id}")
    public ResponseEntity<?> detail(@PathVariable int book_id){
        return new ResponseEntity<>(booksService.queryBookDetailById(book_id), HttpStatus.OK);
    }

    @GetMapping("/mybook/{user_id}/{page_num}")
    public ResponseEntity<?> myBook(@PathVariable int user_id, @PathVariable int page_num){
        return new ResponseEntity<>(booksService.queryMyBookById(user_id, page_num), HttpStatus.OK);
    }

    @GetMapping("/subject/{subject}/{page_num}")
    public ResponseEntity<?> subjectbook(@PathVariable String subject, @PathVariable int page_num){
        return new ResponseEntity<>(booksService.queryBooksBySubject(subject, page_num), HttpStatus.OK);
    }

    // ======================================================
    // Delete - DEL
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) throws Exception {
        return new ResponseEntity<String>(booksService.deleteBookById(id), HttpStatus.OK);
    }

    // ======================================================
    // Update - PUT
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateById(@RequestBody Books books, @PathVariable int id, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<Books>(booksService.addBooks(books), HttpStatus.OK);
//    }

}
