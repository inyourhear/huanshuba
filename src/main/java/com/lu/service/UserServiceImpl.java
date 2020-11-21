package com.lu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lu.mapper.UserMapper;
import com.lu.pojo.Keys;
import com.lu.pojo.User;
import com.lu.utils.GetOpenid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //===============================================
    //Create
    public ResponseEntity<?> addUser(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String code = user.getCode();
        String nickName = user.getNickname();
        String avatarUrl = user.getUser_photo();
        String requestResult = new GetOpenid().getOpenid(code);
        Keys keys = mapper.readValue(requestResult, Keys.class);

        if (userMapper.queryUserIdByOpenId(keys.getOpenid()) != null){
            return new ResponseEntity<>(userMapper.queryUserIdByOpenId(keys.getOpenid()), HttpStatus.BAD_REQUEST);
        }else {
            userMapper.addUser(keys.getOpenid(), nickName, avatarUrl);
            int user_id = userMapper.queryUserIdByOpenId(keys.getOpenid());
            return new ResponseEntity<>(user_id, HttpStatus.OK);
        }
    }

    //=================================
    //Read
    public User queryUserByBookReleaseId(int book_releaser_id) {
        if (book_releaser_id > 0){
            return userMapper.queryUserByBookReleaseId(book_releaser_id);
        }else {
            return null;
        }
    }

    public String queryNicknameByNoteSenderId(int note_sender_id) {
        return userMapper.queryNicknameByNoteSenderId(note_sender_id);
    }

    public int identity(int userId, int school_number) {
        return userMapper.identity(userId, school_number);
    }

    public int deleteUserById(int userId) {
        return userMapper.deleteUserById(userId);
    }
}
