package com.example.naunem.secondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by naunem on 08/03/2017.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText pass;
    RadioButton rdMale;
    RadioButton rdFemale;
    CheckBox cbFootball;
    CheckBox cbListenMusic;
    CheckBox cbSuftWeb;
    CheckBox cbCommic;
    Button btnRegister;
    ImageView showpass;
    ArrayList<CheckBox> list = new ArrayList<>();
    private int passwordNotVisible = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username = (EditText) findViewById(R.id.edittext_username);
        pass = (EditText) findViewById(R.id.edittext_pass);
        rdMale = (RadioButton) findViewById(R.id.male);
        rdFemale = (RadioButton) findViewById(R.id.female);
        cbFootball = (CheckBox) findViewById(R.id.cb_football);
        cbListenMusic = (CheckBox) findViewById(R.id.cb_listen_music);
        cbSuftWeb = (CheckBox) findViewById(R.id.cb_suft_web);
        cbCommic = (CheckBox) findViewById(R.id.cb_commic);
        btnRegister = (Button) findViewById(R.id.register);
        btnRegister.setOnClickListener(this);
        showpass = (ImageView) findViewById(R.id.showpass);
        showpass.setOnClickListener(this);

        list.add(cbFootball);
        list.add(cbListenMusic);
        list.add(cbSuftWeb);
        list.add(cbCommic);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                String gender = "";
                if (rdMale.isChecked()) {
                    gender = rdMale.getText().toString();
                } else {
                    gender = rdFemale.getText().toString();
                }

                String hobby = "";
                for (CheckBox item : list) {
                    if (item.isChecked()) {
                        hobby += item.getText().toString() + " ";
                    }
                }
                String text = "";
                text += "username: " + username.getText() + "\npass: " + pass.getText() + "\ngender: " + gender + "\nhobby: " + hobby;
                Toast.makeText(this, "result: \n" + text, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.showpass:
                if(passwordNotVisible == 1) {
                    pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible = 0;
                } else {
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;
                }
                pass.setSelection(pass.length());
                break;
        }
    }
}
