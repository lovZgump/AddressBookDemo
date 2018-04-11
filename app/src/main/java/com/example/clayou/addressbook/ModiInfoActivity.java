package com.example.clayou.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import android.widget.ImageView;

public class ModiInfoActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editPhoneNum;
    private EditText editEmail;
    private EditText editAddress;

    private ImageView avatar;

    private String name;
    private String phoneNum;
    private String email;
    private String address;
    private int avatarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modi_info);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        phoneNum = intent.getStringExtra("phoneNum");
        email = intent.getStringExtra("email");
        address = intent.getStringExtra("address");
        avatarId = intent.getIntExtra("avatar", 1);

        editName = findViewById(R.id.editName);
        editName.setText(name);
       // editName.setSelection(name.length());

        editPhoneNum = findViewById(R.id.editPhoneNum);
        editPhoneNum.setText(phoneNum);
       // editPhoneNum.setSelection(phoneNum.length());

        editEmail = findViewById(R.id.editEmail);
        editEmail.setText(email);

        editAddress = findViewById(R.id.editAddress);
        editAddress.setText(address);

        avatar = findViewById(R.id.avatar);
        avatar.setImageResource(avatarId);
    }
}
