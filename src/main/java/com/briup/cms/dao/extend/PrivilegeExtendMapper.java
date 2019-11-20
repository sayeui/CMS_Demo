package com.briup.cms.dao.extend;

import com.briup.cms.bean.Privilege;
import com.briup.cms.bean.extend.PrivilegeExtend;

import java.util.List;

public interface PrivilegeExtendMapper {
    List<PrivilegeExtend> selectPrivilegeTree();
    List<Privilege> selectByParentId(long parentId);
}