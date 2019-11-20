package com.briup.cms.service.impl;

import com.briup.cms.bean.extend.PrivilegeExtend;
import com.briup.cms.dao.extend.PrivilegeExtendMapper;
import com.briup.cms.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

    @Autowired
    PrivilegeExtendMapper extendMapper;

    @Override
    public List<PrivilegeExtend> findPrivilegeTree() {
        return extendMapper.selectPrivilegeTree();
    }
}
