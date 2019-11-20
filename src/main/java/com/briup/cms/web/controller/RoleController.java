package com.briup.cms.web.controller;

import com.briup.cms.bean.Role;
import com.briup.cms.bean.extend.RoleExtend;
import com.briup.cms.service.IRoleService;
import com.briup.cms.utils.CustomerException;
import com.briup.cms.utils.Message;
import com.briup.cms.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService service;

    @GetMapping("findAll")
    public Message findAll() {

        return MessageUtil.success(service.findAll());
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Role role) throws CustomerException {

        service.saveOrUpdate(role);
        return MessageUtil.success("保存或更新成功");
    }

    @GetMapping("deleteById")
    public Message deleteById(long id) throws CustomerException {

        service.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findById")
    public Message findById(long id) {

        return MessageUtil.success(service.findById(id));
    }

    @GetMapping("cascadePrivilegeFindAll")
    public Message cascadePrivilegeFindAll() {

        List<RoleExtend> roleExtends = service.cascadePrivilegeFindAll();
        return MessageUtil.success(roleExtends);
    }

    @PostMapping("authorization")
    public Message authorization(long id, Long[] privileges) {

        service.authorization(id, Arrays.asList(privileges));
        return MessageUtil.success("success!");
    }


}
