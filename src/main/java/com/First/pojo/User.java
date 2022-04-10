package com.First.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private int secret_question;
    private String secret_answer;
    private String avator;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSecret_question() {
        return secret_question;
    }

    public void setSecret_question(int secret_question) {
        this.secret_question = secret_question;
    }

    public String getSecret_answer() {
        return secret_answer;
    }

    public void setSecret_answer(String secret_answer) {
        this.secret_answer = secret_answer;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }
}
