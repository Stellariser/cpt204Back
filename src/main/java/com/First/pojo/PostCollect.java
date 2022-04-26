package com.First.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCollect {
    private int id;
    private int postId;
    private int collectedBy;
    private LocalDateTime collectedTime;

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

    public int getCollectedBy() {
        return collectedBy;
    }

    public void setCollectedBy(int collectedBy) {
        this.collectedBy = collectedBy;
    }

    public LocalDateTime getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(LocalDateTime collectedTime) {
        this.collectedTime = collectedTime;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
