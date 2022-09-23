package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmproject.databinding.ActivityLoginBinding;
import com.example.mvvmproject.viewmodel.LoginVM;

public class LoginActivity extends AppCompatActivity {
    private NetworkBroadcast networkBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        networkBroadcast = new NetworkBroadcast();

        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        LoginVM loginVM = new LoginVM();
        activityLoginBinding.setLogin(loginVM);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkBroadcast,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(networkBroadcast);
    }
}

