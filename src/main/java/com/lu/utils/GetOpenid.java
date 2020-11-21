package com.lu.utils;

import org.springframework.web.client.RestTemplate;

public class GetOpenid {
    public String getOpenid(String code){
        RestTemplate restTemplate = new RestTemplate();
        String HOST = "https://api.weixin.qq.com/sns/jscode2session";
        String APPID = "wx559b7ff7bebff17e";
        String SECRET = "870d2f2ed05095d95ac39503290165f2";
        String url = HOST + "?appid=" +
                APPID + "&secret=" +
                SECRET + "&js_code=" +
                code + "&grant_type=authorization_code";
        String requestResult = restTemplate.getForObject(url, String.class);
        return requestResult;
    }
}
