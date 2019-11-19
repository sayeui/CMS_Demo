package com.briup.cms.web.controller;

import com.briup.cms.bean.Role;
import com.briup.cms.bean.extend.RoleExtend;
import com.briup.cms.service.IRoleService;
import com.briup.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService service;

    @GetMapping("findAll")
    public List<Role> findAll() {

        return service.findAll();
    }

    @PostMapping("saveOrUpdate")
    public void saveOrUpdate(Role role) throws CustomerException {

        service.saveOrUpdate(role);
    }

    @GetMapping("deleteById")
    public void deleteById(long id) throws CustomerException {

        service.deleteById(id);
    }

    @GetMapping("findById")
    public RoleExtend findById(long id) {

        return service.findById(id);
    }


}
