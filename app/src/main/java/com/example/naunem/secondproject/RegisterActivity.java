package com.example.naunem.secondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by naunem on 08/03/2017.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    EditText edtUsername;
    EditText edtPassword;
    RadioButton rbMale;
    RadioButton rbFemale;
    CheckBox chkFootball;
    CheckBox chkListenMusic;
    CheckBox chkSuftWeb;
    CheckBox chkCommic;
    Button btnRegister;
    ImageView imgShowPass;
    ArrayList<CheckBox> lists = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        chkFootball = (CheckBox) findViewById(R.id.chkFootball);
        chkListenMusic = (CheckBox) findViewById(R.id.chkListenMusic);
        chkSuftWeb = (CheckBox) findViewById(R.id.chkSuftWeb);
        chkCommic = (CheckBox) findViewById(R.id.chkCommic);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        imgShowPass = (ImageView) findViewById(R.id.imgShowPass);
        imgShowPass.setOnTouchListener(this);

        lists.add(chkFootball);
        lists.add(chkListenMusic);
        lists.add(chkSuftWeb);
        lists.add(chkCommic);
    }

    public String getGender(){
        String gender = "";
        if (rbMale.isChecked()) {
            gender = rbMale.getText().toString();
        } else {
            gender = rbFemale.getText().toString();
        }
        return "\nGender: " + gender;
    }

    public String getHobby(){
        String hobby = "";
        for (CheckBox item : lists) {
            if (item.isChecked()) {
                hobby += item.getText().toString() + " ";
            }
        }
        return "\nHobby: " + hobby;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                String result = "";
                result += "Username: " + edtUsername.getText() + "\nPassword: " + edtPassword.getText() + getGender()  + getHobby();
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            edtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        if (MotionEvent.ACTION_UP == event.getAction()) {
            edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        return true;
    }
}
