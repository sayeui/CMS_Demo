package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.ArticleExample;
import com.briup.cms.bean.extend.ArticleExtend;
import com.briup.cms.dao.ArticleMapper;
import com.briup.cms.dao.extend.ArticleExtendMapper;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {
        return articleExtendMapper.selectAll();
    }

    @Override
    public List<Article> findByCategory(long category_id) {
        return articleExtendMapper.selectByCategory(category_id);
    }

    @Override
    public ArticleExtend findById(long article_id) {

        return articleExtendMapper.selectById(article_id);
    }

    @Override
    public void deleteById(long article_id) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(article_id);
        if (article != null) {
            articleMapper.deleteByPrimaryKey(article_id);
        } else {
            throw new CustomerException("文章不存在");
        }
    }

    @Override
    public void saveOrUpdate(Article article) throws CustomerException {
        if (article.getId() != null) {
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            articleMapper.updateByPrimaryKey(article);
        } else {
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> articles = articleMapper.selectByExample(articleExample);
            if (articles.size() == 0) {
                article.setPublishTime(new Date().getTime());
                article.setStatus(ArticleExtend.STATUS_UNCHECK);
                articleMapper.insert(article);
            } else {
                throw new CustomerException("文章名字已存在");
            }
        }
    }

    @Override
    public void thumpUp(long article_id) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(article_id);
        Long thumpUp = article.getThumpUp();
        if (thumpUp == null) {
            thumpUp = 0L;
        }
        article.setThumpUp(thumpUp + 1L);
        saveOrUpdate(article);
    }

    @Override
    public void thumpDown(long article_id) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(article_id);
        Long thumpDown = article.getThumpDown();
        if (thumpDown == null) {
            thumpDown = 0L;
        }
        article.setThumpDown(thumpDown + 1L);
        saveOrUpdate(article);
    }

    @Override
    public void readArticle(long articleId) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(articleId);

        if (article == null) {
            throw new CustomerException("文章不存在");
        }
        Long readTimes = article.getReadTimes();
        if (readTimes == null) {
            readTimes = 0L;
        }
        article.setReadTimes(readTimes + 1L);
        articleMapper.updateByPrimaryKey(article);

    }
}
