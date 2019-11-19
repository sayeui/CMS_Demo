package com.briup.cms.dao.extend;

import com.briup.cms.bean.Privilege;

import java.util.List;

public interface RolePrivilegeExtendMapper {
    List<Privilege> findByRoleId(long id);
}
