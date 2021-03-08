package com.omkabel.e_saku.Features;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.omkabel.e_saku.R;
import com.omkabel.e_saku.Utils.Page;
import com.omkabel.e_saku.View.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_Register extends AppCompatActivity implements User {
    @BindView(R.id.RegisterEmail)
    TextInputEditText RegisterEmail;
    @BindView(R.id.RegisterNama)
    TextInputEditText RegisterNama;
    @BindView(R.id.RegisterTelpon)
    TextInputEditText RegisterTelpon;
    @BindView(R.id.RegisterPassword)
    TextInputEditText RegisterPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_login)
    Button btnLogin;
    Page page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__register);
        ButterKnife.bind(this);
    }

    public void Signin(View view) {
        goto_login();
    }

    public void signup(View view) {
//        Toast.makeText(this, "CROT", Toast.LENGTH_SHORT).show();
        validasi();
    }

    private void validasi() {
        String email=RegisterEmail.getText().toString();
        String nama=RegisterNama.getText().toString();
        String telpon=RegisterTelpon.getText().toString();
        String psw=RegisterPassword.getText().toString();
        if (email.isEmpty()){
            Toast.makeText(this, "Email Tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else if (nama.isEmpty()){
            Toast.makeText(this, "Nama Tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else if (telpon.isEmpty()){
            Toast.makeText(this, "Telpon Tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else if(psw.isEmpty()){
            Toast.makeText(this, "Password Tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {

        }

    }

    public void goto_login(){
        Intent intent=new Intent(Menu_Register.this,Menu_Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goto_login();
    }
    @Override
    public void Berhasil(String Message){
    }
    @Override
    public void Gagal(String Message){
    }

    @Override
    public void No_Internet(String Message){
    }
}