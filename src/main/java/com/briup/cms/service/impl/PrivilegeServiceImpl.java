package com.briup.cms.service.impl;

import com.briup.cms.bean.Privilege;
import com.briup.cms.bean.PrivilegeExample;
import com.briup.cms.bean.extend.PrivilegeExtend;
import com.briup.cms.dao.PrivilegeMapper;
import com.briup.cms.dao.extend.PrivilegeExtendMapper;
import com.briup.cms.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

    @Autowired
    PrivilegeExtendMapper extendMapper;
    @Autowired
    PrivilegeMapper mapper;

    @Override
    public List<PrivilegeExtend> findPrivilegeTree() {
        return extendMapper.selectPrivilegeTree();
    }

    @Override
    public List<Privilege> findByParentId(Long parentId) {
        PrivilegeExample example = new PrivilegeExample();
        if (parentId == null) {
            example.createCriteria().andParentIdIsNull();
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }
        return mapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Privilege privilege) {
        if (privilege.getId() != null) {
            mapper.updateByPrimaryKey(privilege);
        } else {
            mapper.insert(privilege);
        }
    }
}
