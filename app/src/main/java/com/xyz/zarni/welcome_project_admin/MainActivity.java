package com.xyz.zarni.welcome_project_admin;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab_home: changeFragment(new KingResultFragment());
                        break;

                    case R.id.tab_new: changeFragment(new QueenResultFragment());
                        break;

                    case R.id.tab_fav: changeFragment(new AdminControlFragment());
                        break;

                    default: changeFragment(new KingResultFragment());
                        break;
                }
            }
        });

    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,fragment).commit();
    }

}
