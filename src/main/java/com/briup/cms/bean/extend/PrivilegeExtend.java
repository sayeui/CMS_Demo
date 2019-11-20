package com.briup.cms.bean.extend;

import com.briup.cms.bean.Privilege;

import java.util.List;

public class PrivilegeExtend extends Privilege {
    private List<Privilege> children;

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren( List<Privilege> children) {
        this.children = children;
    }
}
