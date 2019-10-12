package com.ambereye.community.controller;

import com.ambereye.community.annotation.HasLogin;
import com.ambereye.community.dto.CommentCreateDTO;
import com.ambereye.community.dto.CommentDTO;
import com.ambereye.community.dto.ResultDTO;
import com.ambereye.community.enums.CommentTypeEnum;
import com.ambereye.community.exception.CustomizeErrorCodeEnum;
import com.ambereye.community.model.Comment;
import com.ambereye.community.model.User;
import com.ambereye.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/22
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/comment")
    @ResponseBody
    @HasLogin
    public Object post(@RequestBody CommentCreateDTO commentDTO, HttpServletRequest request, @SessionAttribute User user) {

        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment,user);
        return ResultDTO.okOf();
    }


    @GetMapping("/comment/{id}")
    @ResponseBody
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS = commentService.listByQuestionId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

}
