package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.extend.CategoryExtend;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
    Category findById(long category_id);
    List<Category> findAllParent();

    void saveOrUpdate(Category category) throws CustomerException;

    void deleteById(long categoryId) throws CustomerException;

    List<CategoryExtend> cascadeFindAll();

    void batchDelete(long[] ids) throws CustomerException;
}
