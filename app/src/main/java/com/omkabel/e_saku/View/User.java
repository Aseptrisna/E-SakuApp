package com.omkabel.e_saku.View;

import com.omkabel.e_saku.Model.Model_User;

import java.util.List;

public interface User {
    void Berhasil(String message, String Message);

    void Gagal(String Message);

    void No_Internet(String Message);

    void Berhasil(List<Model_User> datauser);
}
