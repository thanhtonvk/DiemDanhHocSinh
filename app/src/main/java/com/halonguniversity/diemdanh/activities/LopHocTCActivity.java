package com.halonguniversity.diemdanh.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.halonguniversity.diemdanh.R;
import com.halonguniversity.diemdanh.adapters.SinhVienTCAdapter;
import com.halonguniversity.diemdanh.entities.SinhVienLopTC;
import com.halonguniversity.diemdanh.service.ApiService;
import com.halonguniversity.diemdanh.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LopHocTCActivity extends AppCompatActivity {

    RecyclerView rcvSV;
    SinhVienTCAdapter adapter;
    List<SinhVienLopTC> sinhVienList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_hoc_tcactivity);
        rcvSV = findViewById(R.id.rcv_sv);
        load();
        findViewById(R.id.btn_diem_danh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DiemDanhActivity.class));
            }
        });
    }

    private void load() {
        ApiService.api.getDsLopHocTC(Constants.maloptc).enqueue(new Callback<List<SinhVienLopTC>>() {
            @Override
            public void onResponse(Call<List<SinhVienLopTC>> call, Response<List<SinhVienLopTC>> response) {
                if (response.isSuccessful()) {
                    sinhVienList = response.body();
                    adapter = new SinhVienTCAdapter(getApplicationContext(), sinhVienList);
                    rcvSV.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<SinhVienLopTC>> call, Throwable t) {

            }
        });
    }
}