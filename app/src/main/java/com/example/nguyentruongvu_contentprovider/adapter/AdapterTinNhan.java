package com.example.nguyentruongvu_contentprovider.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.nguyentruongvu_contentprovider.R;
import com.example.nguyentruongvu_contentprovider.model.TinNhan;

import java.util.List;

public class AdapterTinNhan extends ArrayAdapter<TinNhan> {
    Activity context;
    int resource;
    @NonNull
    List<TinNhan> objects;

    public AdapterTinNhan(@NonNull Activity context, int resource, @NonNull List<TinNhan> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource, null);

        CardView cardView = row.findViewById(R.id.card_view);

        if (position % 2 == 0) {
            cardView.setCardBackgroundColor(Color.LTGRAY);
        } else {
            cardView.setCardBackgroundColor(Color.WHITE);
        }

        TextView _number = row.findViewById(R.id.txt_phone);
        TextView _time = row.findViewById(R.id.txt_time);
        TextView _body = row.findViewById(R.id.txt_body);

        _number.setText(this.objects.get(position).getNumber());
        _time.setText(this.objects.get(position).getTime());
        _body.setText(this.objects.get(position).getBody());

        return row;
    }
}
