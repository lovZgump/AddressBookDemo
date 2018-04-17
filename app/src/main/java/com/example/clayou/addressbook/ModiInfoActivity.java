package com.example.clayou.addressbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        phoneNum = intent.getStringExtra("phoneNum");
        email = intent.getStringExtra("email");
        address = intent.getStringExtra("address");
        avatarId = intent.getIntExtra("avatar", 1);

        editName = findViewById(R.id.editName);
        editName.setText(name);
        editName.setSelection(name.length());

        editPhoneNum = findViewById(R.id.editPhoneNum);
        editPhoneNum.setText(phoneNum);

        editEmail = findViewById(R.id.editEmail);
        editEmail.setText(email);

        editAddress = findViewById(R.id.editAddress);
        editAddress.setText(address);

        avatar = findViewById(R.id.avatar);
        avatar.setImageResource(avatarId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_save) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(ModiInfoActivity.this);
            dialog.setTitle("保存");
            dialog.setMessage("是否保存对该联系人的修改");
            dialog.setCancelable(false);
            dialog.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(ModiInfoActivity.this, "修改已保存", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            dialog.show();
        }



        return  super.onOptionsItemSelected(item);
    }
}
