package com.First.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectPost {
    private int userId;
    private int postId;

    public int getUserId(){
        return userId;
    }

    public void setUserId(){
        this.userId=userId;
    }

    public int getPostId(){
        return postId;
    }

    public void setPostId(){
        this.postId=postId;
    }
    
}
