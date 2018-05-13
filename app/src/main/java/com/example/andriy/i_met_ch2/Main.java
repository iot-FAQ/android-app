package com.example.andriy.i_met_ch2;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;
    private Fragment homeFragment;
    private Fragment profileFragment;
    private Fragment settingsFragment;
    //    private Fragment statisticFragment;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Статистика");
        navigationView = (BottomNavigationView) findViewById(R.id.navigation_menu);
        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        settingsFragment = new SettingsFragment();
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentPlace, homeFragment);
        fragmentTransaction.commit();
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_settings:
                setTitle("Налаштування");
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, settingsFragment);
                fragmentTransaction.commit();
                break;
            case R.id.navigation_profile:
                setTitle("Профіль");
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, profileFragment);
                fragmentTransaction.commit();
                break;
            case R.id.navigation_home:
                setTitle("Статистика");
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, homeFragment);
                fragmentTransaction.commit();
                break;
        }
        return true;
    }

}
