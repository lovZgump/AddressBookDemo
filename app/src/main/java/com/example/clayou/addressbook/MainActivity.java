package com.example.clayou.addressbook;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        WordsNavigation.onWordsChangeListener, AbsListView.OnScrollListener{

    private ListView listView;
    private Handler handler;
    private TextView textView;
    private WordsNavigation wordsNavigation;

    private List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        wordsNavigation = findViewById(R.id.wordsOrder);
        wordsNavigation.setOnWordsChangeListener(this);

        initContacts();
        //ContactsAdapter adapter = new ContactsAdapter(MainActivity.this, R.layout.contacts, contactsList);
        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, contactsList);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(this);

        handler = new Handler();

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void wordsChange(String words) {
        updateWord(words);
        updateListView(words);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        // 当列表滑动时，更新右侧字母列表的选中状态
        wordsNavigation.setTouchIndex(contactsList.get(i).getHeaderWord());
    }

    /**
     * @param words 首字母
     */
    private void updateListView(String words) {
        for (int i = 0; i < contactsList.size(); i++) {
            String headerWord = contactsList.get(i).getHeaderWord();
            //将手指按下的字母与列表中相同字母开头的项找出来
            if (words.equals(headerWord)) {
                //将列表选中哪一个
                listView.setSelection(i);
                //找到开头的一个即可
                return;
            }
        }
    }

    /**
     * 更新中央的字母提示
     *
     * @param words 首字母
     */
    private void updateWord(String words) {
        textView.setText(words);
        textView.setVisibility(View.VISIBLE);
        //清空之前的所有消息
        handler.removeCallbacksAndMessages(null);
        //1s后让tv隐藏
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.GONE);
            }
        }, 500);
    }

    private void initContacts(){
        Contacts person1 = new Contacts("小明", R.drawable.ic_test, "18340000000",
                "123@qq.com", "辽宁省 大连市");
        contactsList.add(person1);
        Contacts person2 = new Contacts("李华", R.drawable.ic_test, "18340111111",
                "124@qq.com", "吉林省 长春市");
        contactsList.add(person2);
        Contacts person3 = new Contacts("王强", R.drawable.ic_test, "18340222222",
                "125@qq.com", "黑龙江省 哈尔滨市");
        contactsList.add(person3);
        Contacts person4 = new Contacts("宋红", R.drawable.ic_test, "18340333333",
                "126@qq.com", "北京市");
        contactsList.add(person4);
        Contacts person5 = new Contacts("老李", R.drawable.ic_test, "18340444444",
                "127@qq.com", "山东省 济南市" );
        contactsList.add(person5);
        Contacts person6 = new Contacts("易云", R.drawable.ic_test, "18347770000",
                "128@qq.com", "辽宁省 沈阳市");
        contactsList.add(person6);
        Contacts person7 = new Contacts("牧尘", R.drawable.ic_test, "18340000345",
                "129@qq.com", "四川省 成都市");
        contactsList.add(person7);
        Contacts person8 = new Contacts("周杰伦", R.drawable.ic_test, "18340012345",
                "138@qq.com", "弯弯");
        contactsList.add(person8);
        Contacts person9 = new Contacts("萧炎", R.drawable.ic_test, "18349999999",
                "139@qq.com", "福建省 厦门市");
        contactsList.add(person9);
        Contacts person10 = new Contacts("金木", R.drawable.ic_test, "18340343216",
                "121@qq.com", "广东省 广州市");
        contactsList.add(person10);
        Contacts person11 = new Contacts("成龙", R.drawable.ic_test, "18340643236",
                "130@qq.com", "香港");
        contactsList.add(person11);
        Contacts person12 = new Contacts("李连杰", R.drawable.ic_test, "18344525123",
                "131@qq.com", "香港");
        contactsList.add(person12);
        Contacts person13 = new Contacts("阿光", R.drawable.ic_test, "18340854534",
                "133@qq.com", "湖南省 长沙市");
        contactsList.add(person13);


        //对集合排序
        Collections.sort(contactsList, new Comparator<Contacts>() {
            @Override
            public int compare(Contacts lhs, Contacts rhs) {
                //根据拼音进行排序
                return lhs.getPinyin().compareTo(rhs.getPinyin());
            }
        });
    }
}
