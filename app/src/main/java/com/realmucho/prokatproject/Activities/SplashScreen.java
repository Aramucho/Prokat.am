package com.realmucho.prokatproject.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.realmucho.prokatproject.Fragments.DialogFragments.ConnectionFragment;
import com.realmucho.prokatproject.Interfaces.ConnectionCallback;
import com.realmucho.prokatproject.R;

public class SplashScreen extends AppCompatActivity  implements ConnectionCallback{


    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = (ImageView) findViewById(R.id.logo);
        ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() == true) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2500);

        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            ConnectionFragment connectionFragment = new ConnectionFragment();
            connectionFragment.show(fragmentManager, "Connection Fragment");

        }

        }


    @Override
    public void conncallback() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}
