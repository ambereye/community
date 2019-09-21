package com.ambereye.community.model;

import lombok.Data;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/14
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
