package com.briup.cms.web.controller;


import com.briup.cms.bean.User;
import com.briup.cms.utils.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("login")
    public Message<User> login(){

        return null;
    }
}
