package com.ambereye.community.controller;

import com.ambereye.community.annotation.HasLogin;
import com.ambereye.community.dto.QuestionDTO;
import com.ambereye.community.mapper.QuestionMapper;
import com.ambereye.community.model.User;
import com.ambereye.community.service.QuestionService;
import com.ambereye.community.model.Question;
import com.ambereye.community.vo.QuestionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/15
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("title",questionDTO.getTitle());
        model.addAttribute("description",questionDTO.getDescription());
        model.addAttribute("tag",questionDTO.getTag());
        model.addAttribute("id",questionDTO.getId());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }


    @HasLogin
    @PostMapping("/publish")
    public String doPublish(@Valid QuestionVo questionVo, @SessionAttribute User user, Model model){

        model.addAttribute("title",questionVo.getTitle());
        model.addAttribute("description",questionVo.getDescription());
        model.addAttribute("tag",questionVo.getTag());

        Question question = new Question();
        BeanUtils.copyProperties(questionVo, question);
        question.setCreator(user.getId());
        questionService.creatOrUpdate(question);
        return "redirect:/";
    }
}
