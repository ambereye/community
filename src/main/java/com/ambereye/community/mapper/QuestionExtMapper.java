package com.ambereye.community.mapper;

import com.ambereye.community.model.Question;
import com.ambereye.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);

    void incCommentCount(Question question);

    List<Question> selectRelated(Question question);
}