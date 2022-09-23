package com.example.mvvmproject.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.mvvmproject.BR;
import com.example.mvvmproject.model.Users;

public class LoginVM extends BaseObservable {

    public Users users;
    @Bindable
    public String mess_login =null;

    public String getMess_login() {
        return mess_login;
    }

    public void setMess_login(String mess_login) {
        this.mess_login = mess_login;
        notifyPropertyChanged(BR.mess_login);
    }

    @Bindable
    public String getPhonenumber() {
        return users.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        users.setPhonenumber(phonenumber);
        notifyPropertyChanged(BR.phonenumber);
    }
    @Bindable
    public String getPassword() {
        return users.password;
    }

    public void setPassword(String password) {
        users.setPassword(password);
        notifyPropertyChanged(BR.password);
    }

    public LoginVM(){
        users = new Users("","","","","","","","","","");
    }

    public void onClickLogin(){
        Users users = new Users("","","",getPhonenumber(),"",getPassword(),"","","","");
        if (users.isPhone() && users.isPassword()){
            setMess_login("acn");
        } else {
            setMess_login("Insert phonenumber or password");
        }
    }
}
