package com.First.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private String title;
    private int writerId;
    private Date writtenTime;
    private Date updateTime;
    private String content;
    private int anonymous;
    private int kudos; // likes?
    private int criticism; // dislikes?
    private int views;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writer) {
        this.writerId = writer;
    }

    public Date getWrittenTime() {
        return writtenTime;
    }

    public void setWrittenTime(Date writtenTime) {
        this.writtenTime = writtenTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(int anonymous) {
        this.anonymous = anonymous;
    }

    public int getKudos() {
        return kudos;
    }

    public void setKudos(int kudos) {
        this.kudos = kudos;
    }

    public int getCriticism() {
        return criticism;
    }

    public void setCriticism(int criticism) {
        this.criticism = criticism;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
