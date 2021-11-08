package org.techtown.havit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class InformationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView perid;
    private long backKeyPressedTime = 0;

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayShowTitleEnabled(false);


        perid = findViewById(R.id.PersonID);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //뒤로가기 했을 때
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, R.string.button_back, Toast.LENGTH_SHORT);
            toast.show();
            return;

        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            Intent intent = new Intent(this, MainActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);  // 지나온 액티비티 삭제
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);     // 지나온액티비티 삭제 후 갱신
            startActivity(intent);
            toast.cancel();
        } else {
            // super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu1) {

            Intent hintent = new Intent(this, MainActivity.class);
            hintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            hintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(hintent);

        } else if (id == R.id.menu2) {


        } else if (id == R.id.menu3) {

            Intent bintent =  new Intent(this,BasketActivity.class);
            bintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            bintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(bintent);
        } else if (id == R.id.login) {

            Intent iintent = new Intent(this, SignInActivity.class);
            iintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            iintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(iintent);

        } else if (id == R.id.singup) {

            Intent uintent = new Intent(this, SignUpActivity.class);
            uintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            uintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(uintent);
        }


        return true;
    }
}

