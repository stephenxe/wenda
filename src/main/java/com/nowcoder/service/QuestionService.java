package com.nowcoder.service;

import com.nowcoder.dao.QuestionDAO;
import com.nowcoder.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getLatestQuestions(int userId,int offset,int limit){
        return  questionDAO.selectByUserIdAndOffset(userId, offset, limit);
    }
}
