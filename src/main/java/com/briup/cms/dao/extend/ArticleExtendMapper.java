package com.briup.cms.dao.extend;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.extend.ArticleExtend;

import java.util.List;

public interface ArticleExtendMapper {
    List<ArticleExtend> selectAll();
    List<Article> selectByCategory(long id);
    ArticleExtend selectById(long id);

}
