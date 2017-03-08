package com.example.naunem.secondproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView tv1;
    EditText edittext;
    Switch aSwitch;
    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        edittext = (EditText) findViewById(R.id.edittext);
        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setChecked(true);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayList<String> list = new ArrayList<>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        list.add("list 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner2.setAdapter(adapter);


        if (aSwitch.isChecked()) {
            Log.d("TAG", "onCreate: " + aSwitch.isChecked());
        } else {
            Log.d("TAG", "onCreate: " + aSwitch.isChecked());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemClick: " + parent.getItemAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
