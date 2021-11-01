package org.techtown.havit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class WTDetail extends AppCompatActivity {
    Toolbar toolbar1;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wts_detail);

        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//툴바 타이틀 없애기
        toolbar1.setTitle("");
        toolbar1.setSubtitle("");
/////

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


    }
}
