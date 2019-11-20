package com.briup.cms.service;

import com.briup.cms.bean.Privilege;

import java.util.List;

public interface IRolePrivilegeService {
    List<Privilege> findByRoleId(long id);
    void deleteByRoleId(long id);
}
