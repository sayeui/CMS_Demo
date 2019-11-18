package com.briup.cms.bean.extend;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.bean.Comment;
import com.briup.cms.bean.User;

import java.util.List;

public class ArticleExtend extends Article {

    public static final String STATUS_UNCHECK = "待审核";
    public static final String STATUS_PASS = "审核通过";
    public static final String STATUS_NOTPASS = "审核未通过";

    private Category category;
    private User author;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
