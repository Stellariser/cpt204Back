package com.First.service;

import java.util.List;


import com.First.dao.SecretQuestionMapper;
import com.First.pojo.SecretQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretQuestionServiceImpl implements SecretQuestionService {

    @Autowired
    SecretQuestionMapper secretQuestionMapper;

    @Override
    public List<SecretQuestion> listSecretQuestion() {
        return secretQuestionMapper.listSecretQuestion();
    }

}
