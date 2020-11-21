package com.lu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)//json转Keys时忽略没有的对象
public class User {

    private String openid;
    private String nickname;
    private String user_photo;
    @Nullable
    private String user_graduate_time;
    @Nullable
    private int user_id;
    @Nullable
    private String code;

    public User(String openId, String nickname, String user_photo) {
        this.openid = openId;
        this.nickname = nickname;
        this.user_photo = user_photo;
    }

    public User(int userId) {
        this.user_id = userId;
    }
}
