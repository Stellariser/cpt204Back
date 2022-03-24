package com.First.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private int id;
    private int friendA;
    private int friendB;
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getFriendA(){
        return friendA;
    }

    public void setFriendA(int friendA){
        this.friendA = friendA;
    }

    public int getFriendB(){
        return friendB;
    }

    public void setFriendB(int friendB){
        this.friendB = friendB;
    }
    
}
