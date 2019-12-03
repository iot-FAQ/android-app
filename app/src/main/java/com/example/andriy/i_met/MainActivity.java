package com.example.andriy.i_met;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import it.sephiroth.android.library.widget.HListView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private MainFragment mainFragment;
    private StatisticsFragment statisticsFragment;
    private AdviceFragment adviceFragment;
    private BottomNavigationView navigationView;
    private FragmentTransaction fragmentTransaction;
    private ImageView profileIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = new MainFragment();
        statisticsFragment = new StatisticsFragment();
        navigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentPlace, mainFragment);
        navigationView.setSelectedItemId(R.id.bottom_navigation_main);
        navigationView.setOnNavigationItemSelectedListener(this);
        fragmentTransaction.commit();
        profileIcon = findViewById(R.id.profileIcon);
        profileIcon.setOnClickListener(this);

    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_navigation_main:
                mainFragment = new MainFragment();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, mainFragment);
                fragmentTransaction.commit();
                break;
            case R.id.bottom_navigation_statistics:
                statisticsFragment = new StatisticsFragment();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, statisticsFragment);
                fragmentTransaction.commit();
                break;
            case R.id.bottom_navigation_economy:
                adviceFragment = new AdviceFragment();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentPlace, adviceFragment);
                fragmentTransaction.commit();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.profileIcon:
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.settingButton:
                    View parrent = (View) view.getParent();
                    TextView serialNumber = parrent.findViewById(R.id.serialNumberDeviceOnItem);
                    for (Device i : MainFragment.uploadDevice()) {
                        if (i.getSerialNumber() == Integer.valueOf(serialNumber.getText().toString())) {
                            Log.d("ok", String.valueOf(i.getTypeDevice()));
                            Intent intent1 = new Intent(getApplicationContext(), SettingsDeviceActivity.class);
                            intent1.putExtra("serialNumber", i.getSerialNumber());
                            startActivity(intent1);
                            break;
                        }
                    }
                    break;
                case R.id.addDeviceButton:
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Увага");
                    alertDialog.setMessage("Дана функція не доступна на демо версії додатку.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    break;
            }
        }catch (IllegalStateException e){
            Log.e("exception", e.toString());
        }
    }
    protected   boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
