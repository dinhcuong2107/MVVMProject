package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
        activityLoginBinding.setLifecycleOwner(this);

        loginVM.mess_login.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s!= null){
                    Toast.makeText(getApplicationContext(),""+s,Toast.LENGTH_SHORT).show();
                    if (s.equals("successful")){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    if (s.equals("register")){
                        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    if (s.equals("forget")){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    if (s.equals("erorr")){

                    }
                }
            }
        });
    }

    @BindingAdapter({"mess_login"})
    public void show_mess_login(View view, String mess){
        if (mess != null) {
            Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
//            switch (mess) {
//                case "successful":
//                    Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
////                    Context context = view.getContext();
////                    Intent intent = new Intent(context, MainActivity.class);
//////                intent.putExtra("productId", productId);
////                    context.startActivity(intent);
//                case "register":
//                    Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
////                    dialog_error(Gravity.CENTER);
//                case "forget":
//                    Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
////                    dialog_error(Gravity.CENTER);
//                case "error":
//                    Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
////                    dialog_error(Gravity.CENTER);
//                case "facebook":
//                    Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
////                    dialog_error(Gravity.CENTER);
//                case "google":
//                    Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
////                    dialog_error(Gravity.CENTER);
//                case "Insert phonenumber or password":
//                    Toast.makeText(view.getContext(), "" + mess, Toast.LENGTH_SHORT).show();
//            }
        }
    }

    private void dialog_error(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_err_login);

        Window window = dialog.getWindow();
        if (window==null){return;}

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity=gravity;
        if (Gravity.CENTER == gravity){}else {dialog.setCancelable(false);}
        dialog.show();
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

