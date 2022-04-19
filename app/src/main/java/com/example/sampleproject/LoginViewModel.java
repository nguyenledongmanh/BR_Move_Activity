package com.example.sampleproject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LoginViewModel extends BaseObservable {
    private String email, password;
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogin() {
        User user = new User(getEmail(), getPassword());
        
        if (user.isValidEmail() && user.isValidPassword()) {
            Intent intent = new Intent(MainActivity.MY_ACTION);
            context.sendBroadcast(intent);
            Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show();
            MainActivity.intentFromVM = new Intent(context, MainActivity2.class);
            Log.d("onClickLogin: ", String.valueOf(MainActivity.intentFromVM));
        } else {
            Toast.makeText(context, "Email or Password is not valid !!!", Toast.LENGTH_SHORT).show();
        }
    }

}
