package com.example.clayou.addressbook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ListView listView;

    private List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContacts();
        ContactsAdapter adapter = new ContactsAdapter(MainActivity.this, R.layout.contacts, contactsList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contacts contacts = contactsList.get(i);
                Intent intent = new Intent(MainActivity.this, specInfoActivity.class);
                String name = contacts.getName();
                String phoneNum = contacts.getPhoneNum();
                String email = contacts.getEmail();
                String address = contacts.getAddress();
                int avatarId = contacts.getAvatarId();
                intent.putExtra("name", name);
                intent.putExtra("phoneNum", phoneNum);
                intent.putExtra("email", email);
                intent.putExtra("address", address);
                intent.putExtra("avatar", avatarId);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initContacts(){
        Contacts person1 = new Contacts("小明", R.drawable.ic_test, "18340000000",
                "123@qq.com", "辽宁省 大连市");
        contactsList.add(person1);
        Contacts person2 = new Contacts("小华", R.drawable.ic_test, "18340111111",
                "124@qq.com", "吉林省 长春市");
        contactsList.add(person2);
        Contacts person3 = new Contacts("小强", R.drawable.ic_test, "18340222222",
                "125@qq.com", "黑龙江省 哈尔滨市");
        contactsList.add(person3);
        Contacts person4 = new Contacts("小红", R.drawable.ic_test, "18340333333",
                "126@qq.com", "北京市");
        contactsList.add(person4);
        Contacts person5 = new Contacts("小李", R.drawable.ic_test, "18340444444",
                "127@qq.com", "山东省 济南市" );
        contactsList.add(person5);
    }
}
