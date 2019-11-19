package com.briup.cms.dao.extend;

import com.briup.cms.bean.extend.UserExtend;

import java.util.List;

public interface UserExtendMapper {
    List<UserExtend> selectById(long id);
    List<UserExtend> cascadeRoleFindAll();
}
