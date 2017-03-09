package com.example.naunem.secondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    ImageView imgShowPass;
    TextView tvCreateAccount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        imgShowPass = (ImageView) findViewById(R.id.imgShowPass);
        tvCreateAccount = (TextView) findViewById(R.id.tvCreateAccount);
        tvCreateAccount.setOnClickListener(this);
        imgShowPass.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                Toast.makeText(this, "Username: " + edtUsername.getText().toString() + "\nPassword: " + edtPassword.getText().toString(), Toast.LENGTH_LONG).show();
                Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentMain);
                break;
            case R.id.tvCreateAccount:
                Intent intentRegister = new Intent(this, RegisterActivity.class);
                startActivity(intentRegister);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            Log.d("TAG", "onTouch: ");
            edtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        if (MotionEvent.ACTION_UP == event.getAction()) {
            edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        return true;
    }
}
