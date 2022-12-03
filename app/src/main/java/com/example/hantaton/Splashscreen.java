package com.example.hantaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Splashscreen extends AppCompatActivity {
    private Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int user = 1;
            int c=buttonCheckAirplaneMode();
            if (c==0) {
                if (isConnected()){
                    if (!isFinishing()) {
                            Toast.makeText(Splashscreen.this, "Добро пожаловать !", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                    } else {
                    Toast.makeText(Splashscreen.this, "Нет подключения к интернету ! Проверьте связь !", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(Splashscreen.this, "Включен режим полёта ! Для работы приложения выключите его !", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
    public int buttonCheckAirplaneMode (){
        if (Settings.Global.getInt(this.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)!=0){
            //Toast.makeText(getApplicationContext(), "Problem", Toast.LENGTH_SHORT).show();
            return 1;
        }else{
            //Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
            return 0;
        }

    }
    boolean isConnected(){
        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null){
            if (networkInfo.isConnected()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}