package com.briup.cms.service;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.extend.ArticleExtend;
import com.briup.cms.utils.CustomerException;

import java.util.List;

public interface IArticleService {
    List<Article> findAll();
    List<ArticleExtend> cascadeFindAll();
    List<Article> findByCategory(long category_id);
    ArticleExtend findById(long article_id);
    void deleteById(long article_id) throws CustomerException;
    void saveOrUpdate(Article article) throws CustomerException;
    void thumpUp(long article_id) throws CustomerException;
    void thumpDown(long article_id) throws CustomerException;
    void readArticle(long articleId) throws CustomerException;
}
