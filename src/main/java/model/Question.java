package model;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/15
 */
@Getter
@Setter
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
