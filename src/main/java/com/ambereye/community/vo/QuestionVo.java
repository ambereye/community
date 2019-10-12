package com.ambereye.community.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * QuestionVo
 *
 * @author byference
 * @since 2019-10-12
 */
@Data
public class QuestionVo {

    /**
     * id
     */
    private Long id;

    @NotEmpty(message = "标题不能为空")
    private String title;

    private Long gmtCreate;

    private Long gmtModified;

    private Long creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    @NotEmpty(message = "标签不能为空")
    private String tag;

    @NotEmpty(message = "描述不能为空")
    private String description;

}
