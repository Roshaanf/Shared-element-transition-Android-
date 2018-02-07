package com.example.roshaan.sharedelementtransition;

/**
 * Created by Roshaan on 2/6/2018.
 */

public class Model {

    String name;
    int avatar;

    public Model( int avatar,String name) {
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
