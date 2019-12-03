package com.example.andriy.i_met;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingsDeviceActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_device);
        Intent intent = getIntent();
        Spinner periodType = findViewById(R.id.spinnerTypePeriod);
        String[] arrayPeriodType = {"Годин", "Днів", "Тижнів", "Місяць"};
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, arrayPeriodType);
        periodType.setAdapter(adapterSpinner);
        int serialNumberDevice = intent.getIntExtra("serialNumber", 0);
        if (serialNumberDevice != 0) {
            EditText editPeriod = findViewById(R.id.numberPeriod);
            editPeriod.setText("5");
            TextView typeDevice = findViewById(R.id.settingTypeDevice);
            typeDevice.setText(String.valueOf(serialNumberDevice));
            String textAddress = "ADDRESS";
            EditText editAddress = findViewById(R.id.editAdressDevice);
            editAddress.setText(textAddress);
        }
        Button calibrateDevice=findViewById(R.id.buttonCalibrateDevice);
        calibrateDevice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCalibrateDevice:
                Intent intent=new Intent(getApplicationContext(), CalibratingActivity.class);
                startActivity(intent);
        }

    }
}
