package com.omkabel.e_saku.Features;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.omkabel.e_saku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_SplashScreen extends AppCompatActivity {
    @BindView(R.id.icon)
    ImageView Icon;
    @BindView(R.id.name)
    TextView Name;
    Animation uptodown, downtoup,Fadein,FadeOut;
    ProgressDialog Loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__splash_screen);
        ButterKnife.bind(Menu_SplashScreen.this);
        Loading=new ProgressDialog(Menu_SplashScreen.this);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        Fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        FadeOut= AnimationUtils.loadAnimation(this, R.anim.fade_out);
        Icon.setAnimation(uptodown);
        Name.setAnimation(downtoup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Loading.setMessage("Mohon Tunggu......");
                Loading.setCancelable(true);
                Loading.show();
                goto_login();
            }
        }, 5000);
    }

    private  void goto_login(){
        Intent intent=new Intent(Menu_SplashScreen.this,Menu_Login.class);
        startActivity(intent);
        finish();

    }
}