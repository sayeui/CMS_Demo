package com.briup.cms.web.controller;


import com.briup.cms.bean.User;
import com.briup.cms.bean.extend.UserExtend;
import com.briup.cms.service.IUserService;
import com.briup.cms.utils.CustomerException;
import com.briup.cms.utils.Message;
import com.briup.cms.utils.MessageUtil;
import com.briup.cms.vm.UserVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService service;

    @PostMapping("login")
    @ApiOperation("用户登录逻辑")
    public Message<?> login(@RequestBody UserVM userVM, HttpSession session) throws CustomerException {
        // 用户名密码校验
        service.login(userVM.getUsername(), userVM.getPassword());
        // 校验通过后生成token（UUID，未加密）
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        // 将token与username关联并放到session中
        session.getServletContext().setAttribute(token,userVM.getUsername());
        // 封装成Message的Date
        HashMap<String, String> map = new HashMap<>();
        map.put("token",token);
        // 返回Message对象
        return MessageUtil.success(map);
    }
    @GetMapping("info")
    public Message<?> info(String token,HttpSession session) throws CustomerException {
        // 通过token获取Username
        String username = (String) session.getServletContext().getAttribute(token);
        if (username == null) throw new CustomerException("该Token不存在或已失效");
        // 通过username查User
        User user = service.selectByUsername(username);
        UserExtend userExtend = service.selectById(user.getId());
        // 封装
        return MessageUtil.success(userExtend);
    }
    @PostMapping("logout")
    public Message logout(@RequestHeader("X-Token") String token,HttpSession session){
        session.getServletContext().removeAttribute(token);
        return MessageUtil.success("success!");
    }

    @GetMapping("cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        return MessageUtil.success(service.cascadeRoleFindAll());
    }
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        service.saveOrUpdate(user);
        return MessageUtil.success("success");
    }
    @GetMapping("deleteById")
    public Message deleteById(long id){
        service.deleteById(id);
        return MessageUtil.success("success");
    }
    @PostMapping("setRoles")
    public Message setRoles(){
        //todo
        return MessageUtil.success("success!");
    }
}
