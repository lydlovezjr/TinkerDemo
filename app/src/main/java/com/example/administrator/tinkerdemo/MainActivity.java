package com.example.administrator.tinkerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity {

    private TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TinkerPatch.with().fetchPatchUpdate(true);//每次强制访问服务器更新
        initView();
    }

    private void initView() {
        tvHello = findViewById(R.id.tv_hello);
        //tvHello.setText("Hello");
        tvHello.setText("Patch Success");
    }
}
