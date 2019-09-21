package com.ambereye.community.mapper;

import com.ambereye.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/14
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) " +
                        "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("Select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("Select * from user where id = #{id}")
    User findById(@Param("id") Integer id );

    @Select("Select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId")String accountId);

    @Update("update user set avatar_url = #{avatarUrl},gmt_modified = #{gmtModified},token = #{token} where id = #{id}")
    void update(User dbUser);
}
