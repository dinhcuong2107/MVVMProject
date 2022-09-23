package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
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
        activityLoginBinding.setLogin(new LoginVM());
        activityLoginBinding.executePendingBindings();
    }

    @BindingAdapter({"mess_login"})
    public static void show_mess_login(View view, String mess){
        if (mess != null){Toast.makeText(view.getContext(),""+mess,Toast.LENGTH_SHORT).show();}
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

