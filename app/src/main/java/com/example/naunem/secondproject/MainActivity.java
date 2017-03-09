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

    TextView tvHello;
    EditText edtText;
    Switch aSwitch;
    Spinner spnOrder;
    Spinner spnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = (TextView) findViewById(R.id.tvHello);

        edtText = (EditText) findViewById(R.id.edtText);
        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setChecked(true);
        spnOrder = (Spinner) findViewById(R.id.spnOrder);

        spnOrder.setOnItemSelectedListener(this);
        spnList = (Spinner) findViewById(R.id.spnList);

        ArrayList<String> list = new ArrayList<>();
        list.add("lists 1");
        list.add("lists 2");
        list.add("lists 3");
        list.add("lists 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spnList.setAdapter(adapter);


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
