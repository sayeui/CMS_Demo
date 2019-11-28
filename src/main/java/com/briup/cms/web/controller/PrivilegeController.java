package com.briup.cms.web.controller;

import com.briup.cms.bean.Privilege;
import com.briup.cms.bean.extend.PrivilegeExtend;
import com.briup.cms.service.IPrivilegeService;
import com.briup.cms.utils.Message;
import com.briup.cms.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("findByParentId")
    public Message findByParentId(Long id) {
        List<Privilege> list = service.findByParentId(id);
        return MessageUtil.success(list);
    }
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Privilege privilege) {
        service.saveOrUpdate(privilege);
        return MessageUtil.success("success!");
    }
}
