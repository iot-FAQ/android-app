package com.example.andriy.i_met;

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
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private Fragment mainFragment;
    private Fragment statisticsFragment;
    private LinearLayout fragmentPlace;
    private BottomNavigationView navigationView;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment= new MainFragment();
        statisticsFragment=new StatisticsFragment();
        fragmentPlace=(LinearLayout) findViewById(R.id.fragmentPlace);
        navigationView=(BottomNavigationView) findViewById(R.id.bottomNavigationView);
        fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentPlace,mainFragment);
        navigationView.setSelectedItemId(R.id.botoom_navigation_main);
        navigationView.setOnNavigationItemSelectedListener(this);
        fragmentTransaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.botoom_navigation_main:
                fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace,mainFragment);
                fragmentTransaction.commit();
            case R.id.botoom_navigation_statistics:
                fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace,statisticsFragment);
                fragmentTransaction.commit();
        }
        return false;
    }
}
