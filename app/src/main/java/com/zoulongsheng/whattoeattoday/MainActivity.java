package com.zoulongsheng.whattoeattoday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zoulongsheng.whattoeattoday.tools.StatusBarUtils;

public class MainActivity extends AppCompatActivity{

    final OneCanteenFragment oneCanteenFragment = new OneCanteenFragment();
    final TwoCanteenFragment twoCanteenFragment = new TwoCanteenFragment();
    final ThreeCanteenFragment threeCanteenFragment = new ThreeCanteenFragment();
    final FourCanteenFragment fourCanteenFragment = new FourCanteenFragment();
    BottomNavigationView bottomNavigationView;
    private View searchBtn;
    private View oneBtn;
    private View twoBtn;
    private View threeBtn;
    private View fourBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
        navigationClick();
    }

    public void init(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        searchBtn = findViewById(R.id.search_btn);
        oneBtn = findViewById(R.id.one_canteen);
        twoBtn = findViewById(R.id.two_canteen);
        threeBtn = findViewById(R.id.three_canteen);
        fourBtn = findViewById(R.id.four_canteen);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout,oneCanteenFragment).commitNow();
    }

    public void navigationClick(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.one_canteen:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout,oneCanteenFragment).commitNow();
                        break;
                    case R.id.two_canteen:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout,twoCanteenFragment).commitNow();
                        break;
                    case R.id.three_canteen:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout,threeCanteenFragment).commitNow();
                        break;
                    case R.id.four_canteen:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout,fourCanteenFragment).commitNow();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);

        MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                return true;
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                return true;
            }
        };
        MenuItem actionMenuItem = menu.findItem(R.id.search_btn);

        MenuItemCompat.setOnActionExpandListener(actionMenuItem, expandListener);

        SearchView searchView =
                (SearchView) actionMenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return true;
    }
}