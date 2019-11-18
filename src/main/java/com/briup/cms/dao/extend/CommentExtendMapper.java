package com.briup.cms.dao.extend;

import com.briup.cms.bean.Comment;

import java.util.List;

public interface CommentExtendMapper {
    List<Comment> selectByArticleId(long id);
}
