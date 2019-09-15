package com.ambereye.community.dto;

import lombok.Data;
import model.User;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/15
 */
@Data
public class QuestionDTO {
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

    private User user;
}
