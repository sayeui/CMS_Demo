package com.briup.cms.dao.extend;

import com.briup.cms.bean.Role;

import java.util.List;

public interface RoleExtendMapper {
    List<Role> selectByUserId(long id);
}
