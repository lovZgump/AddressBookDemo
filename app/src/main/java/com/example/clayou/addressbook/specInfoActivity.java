package com.example.clayou.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class specInfoActivity extends AppCompatActivity {

    private String name;
    private String phoneNum;
   // private String province;
    private String email;
    private String address;
    private int avatarId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spec_info);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        phoneNum = intent.getStringExtra("phoneNum");
       // province = intent.getStringExtra("province");
        email = intent.getStringExtra("email");
        address = intent.getStringExtra("address");
        avatarId = intent.getIntExtra("avatar", 1);

        TextView nameView = findViewById(R.id.nameInfo);
        //TextView proView = findViewById(R.id.provinceInfo);
        Button phoneNumBtn = findViewById(R.id.phoneNumBtn);
        Button emailBtn = findViewById(R.id.emailBtn);
        Button addressBtn = findViewById(R.id.addressBtn);

        ImageView avatar = findViewById(R.id.avatar);
        avatar.setImageResource(avatarId);

        nameView.setText(name);
       // proView.setText(province);
        phoneNumBtn.setText(phoneNum);
        emailBtn.setText(email);
        addressBtn.setText(address);

    }
}
