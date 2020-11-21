package com.lu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lu.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseEntity<?> addUser(User user) throws JsonProcessingException;

    User queryUserByBookReleaseId(int book_releaser_id);

    int deleteUserById(int userId);

    String queryNicknameByNoteSenderId(int note_sender_id);

    int identity(int userId,int school_number);
}
