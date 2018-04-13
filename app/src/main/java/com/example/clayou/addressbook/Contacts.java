package com.example.clayou.addressbook;


/**
 * Created by 10295 on 2018/4/4.
 */

public class Contacts {

    private String name;
    private int avatarId;
    private String phoneNum;
    private String email;
    private String address;

    public Contacts(String name, int avatarId, String phoneNum, String email, String address) {
        this.name = name;
        this.avatarId = avatarId;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
