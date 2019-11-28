package com.briup.cms.service;

import com.briup.cms.bean.Privilege;
import com.briup.cms.bean.extend.PrivilegeExtend;

import java.util.List;

public interface IPrivilegeService {
    List<PrivilegeExtend> findPrivilegeTree();
    List<Privilege> findByParentId(Long parentId);

    void saveOrUpdate(Privilege privilege);
}
