package com.example.nguyentruongvu_contentprovider.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String Phone;
    private String Name;

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Contact(String phone, String name) {
        Phone = phone;
        Name = name;
    }

    @Override
    public String toString() {
        return "Tên: "+ Name +"\nSố điện thoại: "+ this.Phone;
    }
}
