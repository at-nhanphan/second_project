package com.example.naunem.secondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by naunem on 08/03/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText pass;
    Button btnLogin;
    ImageView showPass;
    TextView new_account;
    private int passwordNotVisible = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText) findViewById(R.id.edittext_username);
        pass = (EditText) findViewById(R.id.edittext_pass);
        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(this);
        showPass = (ImageView) findViewById(R.id.showpass);
        new_account = (TextView) findViewById(R.id.new_account);
        new_account.setOnClickListener(this);
//        pass.setTransformationMethod(new PasswordTransformationMethod());
//        showPass.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (MotionEvent.ACTION_DOWN == event.getAction()) {
//                    Log.d("TAG", "onTouch: ");
//                    pass.setTransformationMethod(null);
//                    event.setAction(MotionEvent.ACTION_UP);
//                } else {
//                    pass.setTransformationMethod(new PasswordTransformationMethod());
//                }
//                return false;
//            }
//        });
        showPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Toast.makeText(this, "result : \n" + "username: " + username.getText().toString() + "\npassword: " + pass.getText().toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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
            case R.id.new_account:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
        }
    }
}
