package org.techtown.havit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class RechargeableDetailActivity extends AppCompatActivity {
    Toolbar toolbar1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_detail);

        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//툴바 타이틀 없애기
        toolbar1.setTitle("");
        toolbar1.setSubtitle("");


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);





    }

    public void R1HavitLogo(View v) {
//        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.havitusa.com/"));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
/*
    public void R1ProductPage(View v) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
    public void R1ContactPage(View v) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
    public void R1AboutPage(View v) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

 */
}
