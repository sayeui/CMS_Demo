package com.briup.cms.service.impl;

import com.briup.cms.bean.Role;
import com.briup.cms.bean.RoleExample;
import com.briup.cms.bean.extend.RoleExtend;
import com.briup.cms.dao.RoleMapper;
import com.briup.cms.dao.extend.RoleExtendMapper;
import com.briup.cms.service.IRoleService;
import com.briup.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper mapper;
    @Autowired
    private RoleExtendMapper extendMapper;

    @Override
    public List<Role> findAll() {
        return mapper.selectByExample(new RoleExample());
    }

    @Override
    public void saveOrUpdate(Role role) throws CustomerException {
        if (role.getId() != null) {
            mapper.updateByPrimaryKey(role);
        } else {
            RoleExample example = new RoleExample();
            example.createCriteria().andNameEqualTo(role.getName());
            if (mapper.selectByExample(example).size() != 0) throw new CustomerException("该角色已存在");
            mapper.insert(role);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        if (mapper.selectByPrimaryKey(id) == null) throw new CustomerException("该角色不存在");
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public RoleExtend findById(long id) {
        return extendMapper.selectById(id);
    }
}
