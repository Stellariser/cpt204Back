package com.First.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.First.pojo.SecretQuestion;
import com.First.service.SecretQuestionServiceImpl;
import com.alibaba.fastjson.JSONObject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretQuestionControllor {

    @Autowired
    private SecretQuestionServiceImpl secretQuestionService;

    @GetMapping(value = "getQuestions")
    public String getQuestions() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> questionMap = new HashMap<>();
        List<SecretQuestion> questions = secretQuestionService.listSecretQuestion();
        if (questions != null) {
            map.put("questions", questions);
            questionMap.put("data", map);
            questionMap.put("status", 200);
            questionMap.put("msg", "Get questions successfully.");
        } else {
            questionMap.put("status", 0);
            questionMap.put("msg", "Get questions failed, no questions found.");
        }
        return JSONObject.toJSONString(questionMap);
    }

}
