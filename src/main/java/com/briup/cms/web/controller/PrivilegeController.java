package com.briup.cms.web.controller;

import com.briup.cms.bean.extend.PrivilegeExtend;
import com.briup.cms.service.IPrivilegeService;
import com.briup.cms.utils.Message;
import com.briup.cms.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    IPrivilegeService service;

    @GetMapping("findPrivilegeTree")
    public Message findPrivilegeTree() {
        List<PrivilegeExtend> privilegeTree = service.findPrivilegeTree();
        return MessageUtil.success(privilegeTree);
    }
}
