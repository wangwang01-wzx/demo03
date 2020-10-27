package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Button button=findViewById(R.id.customView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customView(view);
            }
        });
    }
    public void customView(View source)
    {
        // 加载\res\layout\login.xml界面布局文件
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        new AlertDialog.Builder(this)
                // 设置对话框的图标

                // 设置对话框的标题
                //.setTitle("ANDROID APP")
                // 设置对话框显示的View对象
                .setView(loginForm)
                // 为对话框设置一个“确定”按钮
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                // 创建并显示对话框
                .create().show();
    }
}