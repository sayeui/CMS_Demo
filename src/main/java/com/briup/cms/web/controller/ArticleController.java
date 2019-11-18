package com.briup.cms.web.controller;


import com.briup.cms.bean.Article;
import com.briup.cms.bean.extend.ArticleExtend;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.CustomerException;
import com.briup.cms.utils.Message;
import com.briup.cms.utils.MessageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService service;

    @ApiOperation("查询所有文章")
    @GetMapping("/findAll")
    public Message<?> findAll() {
        List<Article> list = service.findAll();
        return MessageUtil.success(list);
    }
    @ApiOperation(value = "级联查询所有文章"  , notes = "级联查询栏目、作者")
    @GetMapping("/cascadeFindAll")
    public Message<?> cascadeFindAll(){
        List<ArticleExtend> list = service.cascadeFindAll();
        return MessageUtil.success(list);
    }
    @ApiOperation(value = "更新或保存文章", notes = "如果参数有id，则认为是更新操作，反之则为保存操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "标题", paramType = "query", required = true),
            @ApiImplicitParam(name = "content", value = "内容", paramType = "query", required = true),
            @ApiImplicitParam(name = "source", value = "源码", paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "栏目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "authorId", value = "作者id", paramType = "query"),
    })
    @PostMapping("/saveOrUpdate")
    public Message<?> saveOrUpdate(
            Long id,
            @NotNull String title,
            @NotNull String content,
            String source,
            @NotNull long categoryId,
            Long authorId) throws CustomerException {
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(authorId);
        service.saveOrUpdate(article);
        return MessageUtil.success("success");
    }
    @ApiOperation("通过id查文章")
    @ApiImplicitParam(name = "articleId", value = "文章ID", paramType = "query")
    @GetMapping("/findById")
    public Message<?> findById(long articleId){
        ArticleExtend obj = service.findById(articleId);
        return MessageUtil.success(obj);
    }
    @ApiOperation("通过栏目ID查文章")
    @ApiImplicitParam(name = "categoryId", value = "栏目ID",paramType = "query")
    @GetMapping("/findByCategory")
    public Message<?> findByCategory(long categoryId){
        List<Article> list = service.findByCategory(categoryId);
        return MessageUtil.success(list);
    }

    @ApiOperation("给文章点赞")
    @ApiImplicitParam(name = "articleId", value = "文章ID",paramType = "query")
    @GetMapping("/thumpUp")
    public Message<?> thumpUp(long articleId) throws CustomerException {
        service.thumpUp(articleId);
        return MessageUtil.success("感谢支持！");
    }

    @ApiOperation("给文章点踩")
    @ApiImplicitParam(name = "articleId", value = "文章ID",paramType = "query")
    @GetMapping("/thumpDown")
    public Message<?> thumpDown(long articleId) throws CustomerException {
        service.thumpDown(articleId);
        return MessageUtil.success("我会继续努力哒！");
    }

    @ApiOperation("通过ID删除文章")
    @ApiImplicitParam(name = "articleId", value = "文章ID",paramType = "query")
    @GetMapping("/deleteById")
    public Message<?> deleteById(long articleId) throws CustomerException {
        service.deleteById(articleId);
        return MessageUtil.success("success!");
    }
    @ApiOperation("阅读文章")
    @ApiImplicitParam(name = "articleId", value = "阅读的文章ID",paramType = "query")
    @GetMapping("/readArticle")
    public Message<?> readArticle(long articleId) throws CustomerException {
        service.readArticle(articleId);
        return MessageUtil.success("success!");
    }


}
