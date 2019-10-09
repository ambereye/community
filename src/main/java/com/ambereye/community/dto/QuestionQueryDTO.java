package com.ambereye.community.dto;

import lombok.Data;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/10/9
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String sort;
    private Long time;
    private String tag;
    private Integer page;
    private Integer size;
}
