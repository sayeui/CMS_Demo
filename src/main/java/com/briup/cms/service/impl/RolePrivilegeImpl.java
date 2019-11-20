package com.briup.cms.service.impl;

import com.briup.cms.bean.Privilege;
import com.briup.cms.dao.RolePrivilegeMapper;
import com.briup.cms.dao.extend.RolePrivilegeExtendMapper;
import com.briup.cms.service.IRolePrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePrivilegeImpl implements IRolePrivilegeService {

    @Autowired
    private RolePrivilegeExtendMapper extendMapper;

    @Override
    public List<Privilege> findByRoleId(long id) {
        return extendMapper.findByRoleId(id);
    }

    @Override
    public void deleteByRoleId(long id) {
        extendMapper.deleteByRoleId(id);
    }
}
