package com.briup.cms.service.impl;

import com.briup.cms.bean.User;
import com.briup.cms.bean.UserExample;
import com.briup.cms.bean.extend.UserExtend;
import com.briup.cms.dao.UserMapper;
import com.briup.cms.dao.extend.UserExtendMapper;
import com.briup.cms.service.IUserService;
import com.briup.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    UserMapper mapper;
    @Resource
    UserExtendMapper extendMapper;

    @Override
    public void login(String username, String password) throws CustomerException {
        User user = selectByUsername(username);
        if (!user.getPassword().equals(password)) throw new CustomerException("密码错误请确认后重试");
    }

    @Override
    public User selectByUsername(String username) throws CustomerException {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = mapper.selectByExample(example);
        if (users.size() == 0) throw new CustomerException("该用户不存在");
        User user = users.get(0);
        return user;
    }

    @Override
    public UserExtend selectById(long id) throws CustomerException {
        UserExtend user = extendMapper.selectById(id).get(0);
        if (user == null) throw new CustomerException("用户不存在");
        return user;
    }
}
