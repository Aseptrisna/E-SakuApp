package com.omkabel.e_saku.Controller;

import android.util.Log;

import com.google.gson.JsonArray;
import com.omkabel.e_saku.Model.Model_User;
import com.omkabel.e_saku.Response.Response_User;
import com.omkabel.e_saku.Server.ApiServices;
import com.omkabel.e_saku.Server.InitRetrofit;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User {
    final com.omkabel.e_saku.View.User user;
    public User(com.omkabel.e_saku.View.User user) {
        this.user = user;
    }
    public void UserRegsiter(String email, String nama, String telpon, String psw){
        retrofit2.Call<ResponseBody> call = InitRetrofit.getInstance().getApi().UserDaftar(nama,email,telpon,psw);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Message=jsonRESULTS.getString("message");
                            user.Berhasil(Message, Message);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Message=jsonRESULTS.getString("message");
                                user.Gagal(Message);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        String error_message ="Ada Masalah Internet";
                        user.No_Internet(error_message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.v("debug", "onFailure: ERROR > " + t.toString());
                try {
                    String error_message ="Server Tidak Merespon";
                    user.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void  UserLogin(String Email,String Password){
        ApiServices api = InitRetrofit.getInstance().getApi();
        Call<Response_User> menuCall = api.UserLogin(Email,Password);
        menuCall.enqueue(new Callback<Response_User>() {
            @Override
            public void onResponse(Call<Response_User> call, Response<Response_User> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<Model_User> datauser= response.body().getUser();
                    boolean status = response.body().isStatus();
                    if (status){
                        try {
                            user.Berhasil(datauser);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        try {
                            String Message="Login Gagal";
                            user.Gagal(Message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Response_User> call, Throwable t) {
                try {
                    String Message="Tidak Ada Internet";
                    user.No_Internet(Message);
                    t.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
