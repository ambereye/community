package com.ambereye.community.mapper;

import model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/14
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_creat,gmt_modified) " +
                        "values (#{name},#{accountId},#{token},#{gmtCreat},#{gmtModified})")
    void insert(User user);
    @Select("Select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
