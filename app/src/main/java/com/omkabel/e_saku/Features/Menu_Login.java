package com.omkabel.e_saku.Features;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonArray;
import com.omkabel.e_saku.Controller.User;
import com.omkabel.e_saku.Features.Pemilik.Dashboard_Pemilik;
import com.omkabel.e_saku.Features.Pengguna.Dashboard_Pengguna;
import com.omkabel.e_saku.Model.Model_User;
import com.omkabel.e_saku.R;
import com.omkabel.e_saku.Session.SharedPrefManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_Login extends AppCompatActivity implements com.omkabel.e_saku.View.User {

    @BindView(R.id.LoginEmail)
    TextInputEditText LoginEmail;
    @BindView(R.id.LoginPassword)
    TextInputEditText LoginPassword;
    @BindView(R.id.btn_signin)
    Button btnSignin;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    ProgressDialog Loading;
    User user;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__login);
        sharedPrefManager=new SharedPrefManager(this);
        ButterKnife.bind(this);
        Loading=new ProgressDialog(this);
        user=new User(this);
        ChexSession();

    }

    private void ChexSession() {
//        String Jenis_Akun = sharedPrefManager.getSPRole();
        if (sharedPrefManager.getSudahLogin()){
            if (sharedPrefManager.getSPRole().equals("Pemilik")) {
                startActivity(new Intent(Menu_Login.this, Dashboard_Pemilik.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            } else if (sharedPrefManager.getSPRole().equals("Pengguna")){
                startActivity(new Intent(Menu_Login.this, Dashboard_Pengguna.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            } else {
//                Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Silahakan Login", Toast.LENGTH_SHORT).show();
        }


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
        String Email=LoginEmail.getText().toString();
        String Password=LoginPassword.getText().toString();
        if (Email.equals("")){
            Toast.makeText(this, "Email Harus Di isi !!!!", Toast.LENGTH_SHORT).show();
        }else if (Password.equals("")){
            Toast.makeText(this, "Password Harus Di isi !!!!", Toast.LENGTH_SHORT).show();
        }else {
            Loading.setMessage("Loading......");
            Loading.setCancelable(true);
            Loading.show();
            user.UserLogin(Email,Password);
        }


    }

    @Override
    public void Berhasil(String message, String Message) {


    }

    private void goto_dashboard() {
        if (sharedPrefManager.getSPRole().equals("Pemilik")) {
            startActivity(new Intent(Menu_Login.this, Dashboard_Pemilik.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        } else if (sharedPrefManager.getSPRole().equals("Pengguna")){
            startActivity(new Intent(Menu_Login.this, Dashboard_Pengguna.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        } else {
//                Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
        }


    }

    private void create_session(List<Model_User> User) {
        String id=User.get(0).getId();
        String Nama=User.get(0).getNama();
        String Email=User.get(0).getEmail();
        String Telpon=User.get(0).getTelpon();
        String Role=User.get(0).getLevel();
        sharedPrefManager.saveSPString(SharedPrefManager.SP_ID, id);
        sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, Nama);
        sharedPrefManager.saveSPString(SharedPrefManager.SP_EMAIL, Email);
        sharedPrefManager.saveSPString(SharedPrefManager.SP_Role, Role);
        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
    }

    @Override
    public void Gagal(String Message) {

    }

    @Override
    public void No_Internet(String Message) {

    }

    @Override
    public void Berhasil(List<Model_User> datauser) {
        Toast.makeText(this, "Berhasil Login .....", Toast.LENGTH_SHORT).show();
        Loading.dismiss();
        create_session(datauser);
        goto_dashboard();

    }
}

