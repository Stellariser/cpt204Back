package com.First.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLikes {
    private int id;
    private int postId;
    private int likedBy;  // User ID
    private LocalDateTime likedTime;

    private boolean canceled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(int likedBy) {
        this.likedBy = likedBy;
    }

    public LocalDateTime getLikedTime() {
        return likedTime;
    }

    public void setLikedTime(LocalDateTime likedTime) {
        this.likedTime = likedTime;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
