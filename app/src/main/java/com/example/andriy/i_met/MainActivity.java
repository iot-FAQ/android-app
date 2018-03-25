package com.example.andriy.i_met;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView navigationView;
    private Fragment settingsFragment;
    private Fragment profileFragment;
    private Fragment statisticFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Статистика");
        navigationView = (BottomNavigationView) findViewById(R.id.navigation_menu);
        profileFragment = new ProfileFragment();
        statisticFragment=new StatisticFragment();
        settingsFragment = new SettingFragment();
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentPlace, profileFragment);
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
                fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, profileFragment);
                fragmentTransaction.commit();
                break;
            case R.id.navigation_statistics:
                setTitle("Статистика");
                fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, statisticFragment);
                fragmentTransaction.commit();
                break;
        }
        return true;
    }
}
