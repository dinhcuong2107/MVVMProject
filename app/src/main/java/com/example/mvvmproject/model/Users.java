package com.example.mvvmproject.model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;

public class Users extends BaseObservable {
    public String fullname;
    public String sex;
    public String dob;
    public String phonenumber;
    public String email;
    public String password;
    public String avatar;
    public String address;
    public String position;
    public String status;

    public Users(String fullname, String sex, String dob, String phonenumber, String email, String password, String avatar, String address, String position, String status) {
        this.fullname = fullname;
        this.sex = sex;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.address = address;
        this.position = position;
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isEmail (){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public boolean isPhone (){
        return !TextUtils.isEmpty(phonenumber) && Patterns.PHONE.matcher(phonenumber).matches();
    }
    public boolean isPassword (){
        return !TextUtils.isEmpty(password) && password.length()>=8;
    }
}