package com.lu.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class Uploads {
    public String uploadImg(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String path = null;
        String type = null;
        if (!file.isEmpty()) {
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath + "/uploads/" + trueFileName;
                    file.transferTo(new File(path));
                } else {
                    return "网络出错了，请重新上传";
                }
            } else {
                return "网络出错了，请重新上传";
            }
        } else {
            return "网络出错了，请重新上传";
        }
        return path;
    }
}
