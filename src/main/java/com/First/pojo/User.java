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
    private int secretQuestion;
    private String secretAnswer;
    private String avator;
    private String gender;
    private String grade;
    private String major;
    private String personalInfo;

    public String getGender() {
        return gender;
    }

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

    public int getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(int secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
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

    public String getPersonalInfo(String personal_info){
        return personal_info;
    }

    public void setPersonalInfo(String personalInfo){
        this.personalInfo = personalInfo;
    }

}
