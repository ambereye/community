package com.ambereye.community.service;

import com.ambereye.community.dto.CommentDTO;
import com.ambereye.community.exception.CustomizeErrorCodeEnum;
import com.ambereye.community.exception.CustomizeException;
import com.ambereye.community.model.Comment;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/22
 */
@Service
public class CommentService {
    public void insert(CommentDTO commentDTO) {
        if(commentDTO == null ||commentDTO.getParentId()==0){
            throw new CustomizeException(CustomizeErrorCodeEnum.TARGET_PARAM_NOT_FUND);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getComment());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(1);
        comment.setLikeCount(0L);
    }
}
