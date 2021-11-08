package org.techtown.havit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback{

    Toolbar toolbar;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment5 fragment5;
    DrawerLayout drawer;
    SearchView searchView;
    ViewPager viewPager;
    private Locale locale2;

    String themeColor;



    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu1) {
            onFragmentSelected(0, null);
        } else if (id == R.id.menu2) {

            Intent intent =  new Intent(this,InformationActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu3) {

            Intent bintent =  new Intent(this,BasketActivity.class);
            startActivity(bintent);
        } else if (id == R.id.login) {

            Intent iintent =  new Intent(this,SignInActivity.class);
            startActivity(iintent);
        }else if (id == R.id.singup) {

            Intent uintent =  new Intent(this,SignUpActivity.class);
            startActivity(uintent);
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
       Locale locale2 = new Locale("en");
        Configuration config2 = new Configuration();

        config2.locale = locale2;
        getResources().updateConfiguration(config2,getResources().getDisplayMetrics());
*/


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer =findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();



        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit(); //첫 번째 화면을 부름

        


        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(R.string.tab_device));
        tabs.addTab(tabs.newTab().setText(R.string.tab_pods));
        tabs.addTab(tabs.newTab().setText(R.string.tab_accessories));
        tabs.addTab(tabs.newTab().setText(R.string.tab_support));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if (position == 2) {
                    selected = fragment3;
                } else if (position == 3) {
                    selected = fragment4;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }


            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment curFragment = null;
                switch (item.getItemId()){
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit() ;
                        return true;
                    case R.id.tab2:

                        Intent bintent =  new Intent(MainActivity.this,BasketActivity.class);
                        startActivity(bintent);




                        return true;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment5).commit() ;
                        return true;
                }
                return false;
                }
        });

        themeColor = ThemeUtil.modLoad(getApplicationContext());
        ThemeUtil.applyTheme(themeColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);

        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView)menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentSelected(int position, Bundle bundle ) {
        Fragment curFragment = null;

        if(position == 0){

            curFragment=fragment1;
          //  toolbar.setTitle("첫 번째 화면");

        }else if (position == 1){
            curFragment=fragment2;
          // toolbar.setTitle("두 번째 화면");
        }else if (position ==2){
            curFragment=fragment3;
         //   toolbar.setTitle("세 번째화면");
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }

    private void restart(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        context.startActivity(mainIntent);
        Runtime.getRuntime().exit(0);
    }
}