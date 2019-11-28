package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.extend.CategoryExtend;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.utils.CustomerException;
import com.briup.cms.utils.Message;
import com.briup.cms.utils.MessageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @GetMapping("/findAll")
    @ApiOperation("查询所有栏目")
    public Message<?> findAll(){
        List<Category> list = service.findAll();
        return MessageUtil.success(list);
    }
    @GetMapping("/cascadeFindAll")
    @ApiOperation("级联查询所有栏目")
    public Message<?> cascadeFindAll(){
        List<CategoryExtend> list = service.cascadeFindAll();
        return MessageUtil.success(list);
    }
    @GetMapping("/findAllParent")
    @ApiOperation("查询所有父栏目")
    public Message<?> findAllParent(){
        List<Category> list = service.findAllParent();
        return MessageUtil.success(list);
    }
    @GetMapping("/findById")
    @ApiOperation("通过ID查询栏目")
    @ApiImplicitParam(name = "category_id",value = "栏目ID",paramType = "query")
    public Message<?> findById(long category_id){
        Category category = service.findById(category_id);
        return MessageUtil.success(category);
    }
    @PostMapping("/saveOrUpdate")
    @ApiOperation("保存或更新栏目")
    @ApiImplicitParams({
       @ApiImplicitParam(name = "id", value = "栏目ID", paramType = "form"),
       @ApiImplicitParam(name = "name", value = "栏目名字", paramType = "form", required = true),
       @ApiImplicitParam(name = "description", value = "栏目描述", paramType = "form"),
       @ApiImplicitParam(name = "parentId", value = "父栏目", paramType = "form"),
    })
    public Message<?> saveOrUpdate(Long id,
                                   @NotNull String name,
                                   String description,
                                   Long parentId) throws CustomerException {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        category.setParentId(parentId);
        System.out.println("=============="+category.getId());
        service.saveOrUpdate(category);
        return MessageUtil.success("保存或更新成功", category);
    }

    @GetMapping("/deleteById")
    @ApiOperation("通过ID删除栏目")
    @ApiImplicitParam(name = "categoryId", value = "要删除的栏目id")
    public Message<?> deleteById(long categoryId) throws CustomerException {
        service.deleteById(categoryId);
        return MessageUtil.success("删除成功");
    }
    @PostMapping("/batchDelete")
    @ApiOperation("批量删除栏目")
    @ApiImplicitParam(name = "ids", value = "要删除的栏目id的数组")
    public Message<?> batchDelete(long[] ids) throws CustomerException {
        service.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }
}
