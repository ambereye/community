package com.ambereye.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/19
 */
public class QuestionController {

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id){

        return "question";
    }


}
