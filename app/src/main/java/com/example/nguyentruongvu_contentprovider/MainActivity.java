package com.example.nguyentruongvu_contentprovider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CONTACT_ASK_PERMISSIONS=1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    Button btn_docdanhba, btn_doctinnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        addEvents();
    }

    private void addControl() {
        btn_docdanhba = findViewById(R.id.btn_docdanhba);
        btn_doctinnhan = findViewById(R.id.btn_doctinnhan);
    }

    private void addEvents() {
        btn_docdanhba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoManHinhDanhBa();
            }
        });
        btn_doctinnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoManHinhTinNhan();
            }
        });
    }

    private void xuLyMoManHinhDanhBa() {

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{""+"android.permission.READ_CONTACTS"}, REQUEST_SMS_ASK_PERMISSIONS);
        } else {
            Intent intent = new Intent(MainActivity.this, DanhBa.class);
            intent.setClassName("com.example.nguyentruongvu_contentprovider", "com.example.nguyentruongvu_contentprovider.DanhBa");
            startActivity(intent);
        }
    }
    private void xuLyMoManHinhTinNhan() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{""+"android.permission.READ_SMS"}, REQUEST_SMS_ASK_PERMISSIONS);
        } else {
            Intent intent = new Intent(MainActivity.this, DocTinNhan.class);
            intent.setClassName("com.example.nguyentruongvu_contentprovider", "com.example.nguyentruongvu_contentprovider.DocTinNhan");
            startActivity(intent);
        }
    }
}