package com.omkabel.e_saku.Features;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.omkabel.e_saku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_Login extends AppCompatActivity {

    @BindView(R.id.LoginEmail)
    TextInputEditText LoginEmail;
    @BindView(R.id.LoginPassword)
    TextInputEditText LoginPassword;
    @BindView(R.id.btn_signin)
    Button btnSignin;
    @BindView(R.id.btn_signup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__login);
        ButterKnife.bind(this);
    }


    public void Register(View view) {
        Intent intent = new Intent(Menu_Login.this, Menu_Register.class);
        startActivity(intent);
        finish();

    }

    public void Login(View view) {
        validasi();
    }

    private void validasi() {

    }
}

