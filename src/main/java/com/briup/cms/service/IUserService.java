package com.briup.cms.service;

import com.briup.cms.bean.User;
import com.briup.cms.bean.extend.UserExtend;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface IUserService {

    void login(String username,String password) throws CustomerException;
    User selectByUsername(String username) throws CustomerException;
    UserExtend selectById(long id) throws CustomerException;
    List<UserExtend> cascadeRoleFindAll();
    void saveOrUpdate(User user);
    void deleteById(long id);
}
