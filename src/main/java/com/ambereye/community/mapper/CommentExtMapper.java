package com.ambereye.community.mapper;

import com.ambereye.community.model.Comment;
import com.ambereye.community.model.CommentExample;
import com.ambereye.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    void incCommentCount(Comment comment);
}