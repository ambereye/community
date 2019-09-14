package com.ambereye.community.dto;

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
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
