package com.ambereye.community.mapper;

import model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/15
 */
@Mapper
public interface QuestionMapper {
@Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) " +
                    "values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void creat(Question question);
}
