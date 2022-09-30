package com.example.mvvmproject.viewmodel;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmproject.BR;
import com.example.mvvmproject.model.Users;

import java.io.Closeable;
import java.util.Observable;
import java.util.logging.Handler;

public class LoginVM extends BaseObservable {
    private String phonenumber;
    private  String password;
    private MutableLiveData<Integer> busy;
    public final MutableLiveData<String> mess_login = new MutableLiveData<>();

    public MutableLiveData<Integer> getBusy(){
        if (busy== null){
            busy = new MutableLiveData<>();
            busy.setValue(8);
        }return busy;
    }

    public LoginVM() {
    }

    private MutableLiveData<Users> usersMutableLiveData;

    LiveData<Users> getUsers(){
        if (usersMutableLiveData==null){
            usersMutableLiveData = new MutableLiveData<>();
        }
        return usersMutableLiveData;
    }
    @Bindable
    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    @Bindable
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void onClickSigup(){
        mess_login.setValue("register");
    }
    public void onClickForget(){
        mess_login.setValue("forget");
    }

    public void onClickLogin(){
        Users users = new Users("","","",getPhonenumber(),"",getPassword(),"","","","");
        if (users.isPhone() && users.isPassword()){
            if (users.phonenumber.equals("12345678"))
            {
                mess_login.setValue("successful");
            }else {
                mess_login.setValue("error");
            }

        } else {
            mess_login.setValue("Insert phonenumber or password");
        }
    }
}
