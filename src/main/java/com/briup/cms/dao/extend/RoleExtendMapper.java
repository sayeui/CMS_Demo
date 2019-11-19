package com.briup.cms.dao.extend;

import com.briup.cms.bean.Role;
import com.briup.cms.bean.extend.RoleExtend;

import java.util.List;

public interface RoleExtendMapper {
    List<Role> selectByUserId(long id);
    RoleExtend selectById(long id);
}
