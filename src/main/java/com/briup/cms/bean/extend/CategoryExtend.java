package com.briup.cms.bean.extend;

import com.briup.cms.bean.Category;

public class CategoryExtend extends Category {
    private Category parent;

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
