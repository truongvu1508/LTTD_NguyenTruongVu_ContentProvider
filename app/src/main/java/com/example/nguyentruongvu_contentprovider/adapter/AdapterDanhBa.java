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
import com.example.nguyentruongvu_contentprovider.model.Contact;

import java.util.List;

public class AdapterDanhBa extends ArrayAdapter<Contact> {
    Activity context;
    int resource;
    @NonNull
    List<Contact> objects;
    public AdapterDanhBa(@NonNull Activity context, int resource, @NonNull List<Contact> objects) {
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
        TextView txtName = row.findViewById(R.id.txt_name);
        TextView txtPhone = row.findViewById(R.id.txt_phone);
        txtName.setText(this.objects.get(position).getName());
        txtPhone.setText(this.objects.get(position).getPhone());
        return row;
    }
}
