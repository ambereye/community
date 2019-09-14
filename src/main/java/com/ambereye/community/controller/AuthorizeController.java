package com.ambereye.community.controller;

import com.ambereye.community.dto.AccessTokenDTO;
import com.ambereye.community.dto.GithubUser;
import com.ambereye.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/14
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name="state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("0c7fd2ce173a7cb73f4e");
        accessTokenDTO.setClient_secret("e5d6dd56b2056de171a9fd197b8d7c84b510b6de");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        System.out.println(user.getBio());
        System.out.println(user.getId());
        return "index";
    }

}
