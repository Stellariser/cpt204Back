package com.First.dao;

import java.util.List;


import com.First.pojo.SecretQuestion;
import org.springframework.stereotype.Component;

@Component
public interface SecretQuestionMapper {

    List<SecretQuestion> listSecretQuestion();

}
