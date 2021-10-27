package org.techtown.havit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

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
            Toast.makeText(this, "첫번째 메뉴 선택됨.kkkkkkkkkk", Toast.LENGTH_LONG).show();
            onFragmentSelected(0, null);
        } else if (id == R.id.menu2) {
            Toast.makeText(this, "두번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(1, null);
        } else if (id == R.id.menu3) {
            Toast.makeText(this, "세번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(2, null);
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        tabs.addTab(tabs.newTab().setText("Devices"));
        tabs.addTab(tabs.newTab().setText("Pods"));
        tabs.addTab(tabs.newTab().setText("Accessories"));
        tabs.addTab(tabs.newTab().setText("Deals"));
        tabs.addTab(tabs.newTab().setText("Support"));
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
                } else if (position == 4) {
                    selected = fragment5;
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


}