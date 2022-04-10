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
    private String gender;
    private String grade;
    private String major;
    private String personal_info;



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

    public String getGender(String gender){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGrade(String grade){
        return grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getMajor(String major){
        return major;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public String getPersonal_info(String personal_info){
        return personal_info;
    }

    public void setPersonal_info(String personal_info){
        this.personal_info = personal_info;
    }

}
