package com.briup.cms.service.impl;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.CategoryExample;
import com.briup.cms.bean.extend.CategoryExtend;
import com.briup.cms.dao.CategoryMapper;
import com.briup.cms.dao.extend.ArticleExtendMapper;
import com.briup.cms.dao.extend.CategoryExtendMapper;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CateGoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper mapper;
    @Resource
    private CategoryExtendMapper extendMapper;
    @Autowired
    private ArticleExtendMapper articleMapper;

    @Override
    public List<Category> findAll() {
        return mapper.selectByExample(new CategoryExample());
    }

    @Override
    public Category findById(long category_id) {
        return mapper.selectByPrimaryKey(category_id);
    }

    @Override
    public List<Category> findAllParent() {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andParentIdIsNull();
        return mapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if (category.getId() == null) {
            CategoryExample example = new CategoryExample();
            example.createCriteria().andNameEqualTo(category.getName());
            if (mapper.selectByExample(example).size() != 0) {
                throw new CustomerException("栏目已存在,请更换名字再试！");
            }
            mapper.insert(category);
        } else {
            mapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public void deleteById(long categoryId) throws CustomerException {
        if (mapper.selectByPrimaryKey(categoryId) == null) {
            throw new CustomerException("包含不存在的栏目");
        }

        if (articleMapper.selectByCategory(categoryId).size() != 0) {
            throw new CustomerException("该栏目下存在文章，无法删除");
        }
        mapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    @Transactional(rollbackFor = {CustomerException.class})
    public List<CategoryExtend> cascadeFindAll() {
        return extendMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = {CustomerException.class})
    public void batchDelete(long[] ids) throws CustomerException {
        for (long id : ids) {
            deleteById(id);
        }
    }
}
