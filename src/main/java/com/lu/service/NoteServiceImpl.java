package com.lu.service;

import com.lu.mapper.NoteMapper;
import com.lu.pojo.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NoteServiceImpl")
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    //==============================================
    //Create
    public ResponseEntity<?> addNote(Note note) {
        if (noteMapper.addNote(note.getNote_book_id(), note.getNote_sender_id(), note.getNote_receiver_id(), note.getNote_content()) > 0)
            return new ResponseEntity<String>("Successful", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
    }

    //==============================================
    //Read
    public List<Note> queryBookNote(int book_id) {
        return noteMapper.queryBookNote(book_id);
    }

    public List<Note> queryMyNote(int user_id) {
        return noteMapper.queryMyNote(user_id);
    }


}
