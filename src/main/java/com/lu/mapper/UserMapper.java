package com.lu.mapper;

import com.lu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int addUser(@Param("openid") String openid,@Param("nickname") String nickname,@Param("user_photo") String user_photo);

    int deleteUserById(@Param("userId") int userId);

    Integer queryUserIdByOpenId(@Param("openId") String openId);

    User queryUserByBookReleaseId(@Param("book_releaser_id") int book_releaser_id);

    String queryNicknameByNoteSenderId(@Param("note_sender_id") int note_sender_id);

    int identity(@Param("userId") int userId,@Param("student_id") int student_id);

}

