package com.lu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)//json转Keys时忽略没有的对象
public class Note {
    private int note_id;
    private int note_receiver_id;
    private int note_sender_id;
    private int note_book_id;
    private String note_content;

    public Note(int note_receiver_id, int note_sender_id, int note_book_id, String note_content) {
        this.note_receiver_id = note_receiver_id;
        this.note_sender_id = note_sender_id;
        this.note_book_id = note_book_id;
        this.note_content = note_content;
    }
}
