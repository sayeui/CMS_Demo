package com.briup.cms.bean.extend;

import com.briup.cms.bean.Privilege;
import com.briup.cms.bean.Role;

import java.util.List;

public class RoleExtend extends Role {

    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
