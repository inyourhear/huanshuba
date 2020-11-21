package com.lu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)//json转Keys时忽略没有的对象
public class Books {
    @Null
    private int book_id;
    @NotNull
    private String book_subject;
    @NotNull
    private String book_title;
    @NotNull
    private String book_detail;
    @NotNull
    private String book_picture;
    @NotNull
    private String book_type;
    @Min(1)
    private int book_releaser_id;
    @Null
    private Date book_create_time;
    @Null
    private Date book_update_time;


    public Books(String book_subject, String book_title, String book_detail, String book_picture, String book_type, int book_releaser_id) {
        this.book_subject = book_subject;
        this.book_title = book_title;
        this.book_detail = book_detail;
        this.book_picture = book_picture;
        this.book_type = book_type;
        this.book_releaser_id = book_releaser_id;


    }
}
