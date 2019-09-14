package com.ambereye.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/13
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){return "index";}
}
