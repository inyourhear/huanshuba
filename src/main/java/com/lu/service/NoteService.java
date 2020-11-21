package com.lu.service;

import com.lu.pojo.Note;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NoteService {

    List<Note> queryBookNote(int book_id);

    List<Note> queryMyNote(int user_id);

    ResponseEntity<?> addNote(Note note);

}
