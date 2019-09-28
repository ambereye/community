package com.ambereye.community.dto;

import com.ambereye.community.model.User;
import lombok.Data;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/25
 */
@Data
public class CommentDTO {
    private Long id;

    private Long parentId;

    private Integer type;

    private Long commentator;

    private Long gmtCreate;

    private Long gmtModified;

    private Long likeCount;

    private String content;

    private Integer commentCount;

    private User user;
}
