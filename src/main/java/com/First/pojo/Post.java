package com.First.pojo;

import java.sql.Time;
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
    private String writerName;
    private Date writtenTime;
    private Date updateTime;
    private String content;
    private int anonymous;
    private int totalLikes; // Once a user liked this post, increase by 1
    private int newLikes; // Once a user liked this post, increase by 1;
                          // if the post owner click the notification set this one to 0.
    private int criticism; // dislikes
    private int totalCollects;
    private int views;
    private int isDeleted;
    private String typeContent;
    private String date;
    private Time ti;
    private int avatar;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public Time getTi() {
        return ti;
    }

    public void setTi(Time ti) {
        this.ti = ti;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public int getTotalCollects() {
        return totalCollects;
    }

    public void setTotalCollects(int totalCollects) {
        this.totalCollects = totalCollects;
    }

    public int getNewLikes() {
        return newLikes;
    }

    public void setNewLikes(int newLikes) {
        this.newLikes = newLikes;
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

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
