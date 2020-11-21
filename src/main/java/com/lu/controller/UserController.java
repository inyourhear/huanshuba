package com.lu.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lu.pojo.User;
import com.lu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //===================================================
    //Create - POST
    //接收code，换取openid,以openid为标识，创建user存入database
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, BindingResult bindingResult) throws JsonProcessingException {
        System.out.println(user.toString());
        if (bindingResult.hasErrors())
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    //===================================================
    //Read - GET
    @GetMapping("/userinfo/{book_releaser_id}")
    public ResponseEntity<?> getReleaseInfo(@PathVariable int book_releaser_id) throws JsonProcessingException {
        return new ResponseEntity<>(userService.queryUserByBookReleaseId(book_releaser_id), HttpStatus.OK);
    }
}
