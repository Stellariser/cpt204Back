package com.First.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private int id;
    private int friend_a;
    private int friend_b;

    public int getId(){
        return id;
    }

    public void setId(){
        this.id=id;
    }

    public int getFriendA(){
        return friend_a;
    }

    public void setFriendA(){
        this.friend_a=friend_a;
    }

    public int getFriendB(){
        return friend_b;
    }

    public void setFriendB(){
        this.friend_a=friend_b;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getFriend_a() {
        return friend_a;
    }

    public void setFriend_a(int friend_a) {
        this.friend_a = friend_a;
    }

    public int getFriend_b() {
        return friend_b;
    }

    public void setFriend_b(int friend_b) {
        this.friend_b = friend_b;
    }
}
