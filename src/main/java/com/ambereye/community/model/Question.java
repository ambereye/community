package com.ambereye.community.model;

import lombok.Data;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/15
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
