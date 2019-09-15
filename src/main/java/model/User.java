package model;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/14
 */
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreat;
    private Long gmtModified;
}
