package com.ambereye.community.dto;

import com.ambereye.community.model.User;
import lombok.Data;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/15
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

    private User user;
}
