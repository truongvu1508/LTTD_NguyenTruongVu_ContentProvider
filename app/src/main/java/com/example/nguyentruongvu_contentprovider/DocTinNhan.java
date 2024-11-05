package com.example.nguyentruongvu_contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.nguyentruongvu_contentprovider.adapter.AdapterTinNhan;
import com.example.nguyentruongvu_contentprovider.model.TinNhan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DocTinNhan extends AppCompatActivity {
    ListView lvDocTinNhan;
    ArrayList<TinNhan> dsTinNhan;
    AdapterTinNhan adapterTinNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doc_tin_nhan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        docToanBoTinNhan();
    }

    private void docToanBoTinNhan() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        if (cursor != null) {
            dsTinNhan.clear();
            try {
                while (cursor.moveToNext()) {

                    int viTriPhoneNumber = cursor.getColumnIndex("address");
                    int viTriTimeStamp = cursor.getColumnIndex("date");
                    int viTriBody = cursor.getColumnIndex("body");

                    if (viTriPhoneNumber != -1 && viTriTimeStamp != -1 && viTriBody != -1) {

                        String phoneNumber = cursor.getString(viTriPhoneNumber);
                        String timeStamp = cursor.getString(viTriTimeStamp);
                        String body = cursor.getString(viTriBody);

                        dsTinNhan.add(new TinNhan(phoneNumber, simpleDateFormat.format(Long.parseLong(timeStamp)), body));
                    } else {
                        Log.e("DocTinNhan", "Không tìm thấy cột cần thiết trong Cursor");
                    }
                }
                adapterTinNhan.notifyDataSetChanged();
            } finally {
                cursor.close();
            }
        }
    }

    private void addControl() {
        lvDocTinNhan = findViewById(R.id.lvDocTinNhan);
        dsTinNhan = new ArrayList<>();
        adapterTinNhan = new AdapterTinNhan(DocTinNhan.this, R.layout.item_tinnhan, dsTinNhan);
        lvDocTinNhan.setAdapter(adapterTinNhan);
    }
}
