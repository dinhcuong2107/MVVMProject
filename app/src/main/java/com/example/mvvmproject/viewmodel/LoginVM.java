package com.example.mvvmproject.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.mvvmproject.BR;
import com.example.mvvmproject.model.Users;

public class LoginVM extends BaseObservable {
    public String phonenumber;
    public String password;
    public ObservableField<String> mess_login = new ObservableField<>();


    @Bindable
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        notifyPropertyChanged(BR.phonenumber);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogin(){
        Users users = new Users("","","",getPhonenumber(),"",getPassword(),"","","","");
        if (users.isPhone() && users.isPassword()){
            mess_login.set("acn");
        } else {
            mess_login.set("Insert phonenumber or password");
        }
    }
}
