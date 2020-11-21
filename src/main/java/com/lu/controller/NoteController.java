package com.lu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lu.pojo.Note;
import com.lu.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    //==============================================
    //Create - POST
    @PostMapping("/add")
    public ResponseEntity<?> addNote(@RequestBody Note note, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        else
            return noteService.addNote(note);
    }

    //==============================================
    //Read - GET
    @GetMapping("/book/{book_id}")
    public ResponseEntity<?> queryBookNote(@PathVariable int book_id){
        return new ResponseEntity<>(noteService.queryBookNote(book_id), HttpStatus.OK);
    }

    @GetMapping("/my/{user_id}")
    public ResponseEntity<?> queryMyNote(@PathVariable int user_id){
        return new ResponseEntity<>(noteService.queryMyNote(user_id), HttpStatus.OK);
    }
}
