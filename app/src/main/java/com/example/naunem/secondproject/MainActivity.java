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

    TextView mTvHello;
    EditText mEdtText;
    Switch mSwOn;
    Spinner mSpnOrder;
    Spinner mSpnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHello = (TextView) findViewById(R.id.tvHello);
        mEdtText = (EditText) findViewById(R.id.edtText);
        mSwOn = (Switch) findViewById(R.id.swOn);
        mSwOn.setChecked(true);
        mSpnOrder = (Spinner) findViewById(R.id.spnOrder);
        mSpnOrder.setOnItemSelectedListener(this);
        mSpnList = (Spinner) findViewById(R.id.spnList);

        ArrayList<String> mLists = new ArrayList<>();
        mLists.add("mLists 1");
        mLists.add("mLists 2");
        mLists.add("mLists 3");
        mLists.add("mLists 4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mLists);
        mSpnList.setAdapter(adapter);

        if (mSwOn.isChecked()) {
            Log.d("TAG", "onCreate: " + mSwOn.isChecked());
        } else {
            Log.d("TAG", "onCreate: " + mSwOn.isChecked());
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
