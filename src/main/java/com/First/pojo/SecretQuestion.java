package com.First.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecretQuestion {

    private int question_id;
    private String question;

    public int getQuestionId() {
        return question_id;
    }

    public void setQuestionId() {
        this.question_id=question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion() {
        this.question=question;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
