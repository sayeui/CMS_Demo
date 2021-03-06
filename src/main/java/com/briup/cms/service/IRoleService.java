package com.briup.cms.service;

import com.briup.cms.bean.Role;
import com.briup.cms.bean.extend.RoleExtend;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();
    List<RoleExtend> cascadePrivilegeFindAll();
    void saveOrUpdate(Role role) throws CustomerException;
    void deleteById(long id) throws CustomerException;
    RoleExtend findById(long id);
    void authorization(long id, List<Long> privileges);

}
