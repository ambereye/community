package com.ambereye.community.service;

import com.ambereye.community.dto.QuestionDTO;
import com.ambereye.community.mapper.QuestionMapper;
import com.ambereye.community.mapper.UserMapper;
import model.Question;
import model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/15
 */
@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;
    
    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> QuestionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            QuestionDTOList.add(questionDTO);
        }
        return QuestionDTOList;
    }
}
