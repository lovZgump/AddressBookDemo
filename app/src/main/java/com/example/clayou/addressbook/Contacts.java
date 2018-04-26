package com.example.clayou.addressbook;


/**
 * Created by 10295 on 2018/4/4.
 */

public class Contacts {

    private String name;
    // 拼音
    private String pinyin;
    // 首字母
    private String headerWord;
    private int avatarId;
    private String phoneNum;
    private String email;
    private String address;

    public Contacts(String name, int avatarId, String phoneNum, String email, String address) {
        this.name = name;
        this.pinyin = PinYinUtils.getPinyin(name);
        this.headerWord = pinyin.substring(0, 1);
        this.avatarId = avatarId;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getHeaderWord() {
        return headerWord;
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
