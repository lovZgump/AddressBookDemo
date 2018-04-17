package com.example.clayou.addressbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class specInfoActivity extends AppCompatActivity {

    private String name;
    private String phoneNum;
    private String email;
    private String address;
    private int avatarId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spec_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(specInfoActivity.this, ModiInfoActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("phoneNum", phoneNum);
                intent.putExtra("email", email);
                intent.putExtra("address", address);
                intent.putExtra("avatar", avatarId);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sepc_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_delete) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(specInfoActivity.this);
            dialog.setTitle("删除联系人");
            dialog.setMessage("确定要删除“" + name + "”吗？");
            dialog.setCancelable(false);
            dialog.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(specInfoActivity.this, "联系人删除成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog.show();
        }else if(id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
