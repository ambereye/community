package com.ambereye.community.dto;

import lombok.Data;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/22
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
