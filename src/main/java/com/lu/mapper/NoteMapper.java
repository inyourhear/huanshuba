package com.lu.mapper;

import com.lu.pojo.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteMapper {

    List<Note> queryBookNote(@Param("book_id") int book_id);

    List<Note> queryMyNote(@Param("user_id") int user_id);

    int addNote(@Param("note_book_id") int note_book_id,
                @Param("note_sender_id") int note_sender_id,
                @Param("note_receiver_id") int note_receiver_id,
                @Param("note_content") String note_content);
}
