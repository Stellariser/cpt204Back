package com.First.service;

import java.util.List;

import com.First.pojo.SecretQuestion;
import org.springframework.stereotype.Service;

@Service
public interface SecretQuestionService {

    List<SecretQuestion> listSecretQuestion();

}
