package com.realmucho.prokatproject.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.realmucho.prokatproject.fragments.dialog_fragments.ConnectionFragment;
import com.realmucho.prokatproject.interfaces.ConnectionCallback;
import com.realmucho.prokatproject.R;

public class SplashScreen extends AppCompatActivity implements ConnectionCallback {


    private ImageView mLogo;
    private final int LOCATION_ON = 111;
    private ConnectivityManager mConnectionManager;
    private NetworkInfo mNetworkInfo;
    private boolean mBoolLocation; //for denying the access of location

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mLogo = (ImageView) findViewById(R.id.logo);
        mConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        mNetworkInfo = mConnectionManager.getActiveNetworkInfo();
        /**Checking permission for google maps feature*/
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_ON);
            } else {
                /**checking inet connection*/
                if (mNetworkInfo != null && mNetworkInfo.isConnected() == true) {
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
        } else {

            if (mNetworkInfo != null && mNetworkInfo.isConnected() == true) {
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
    }

    /**When user there is no connection and user has no permission for location, he must choose allow or deny it.
     * Regardless of the outcome there is an error (illegal state exception) for permission dialog.
     * If user allows permission, activity recreates, and if access is denied, dialog manually is closing
     * and app continues to work with toasting a warning about google map's possible issues.
      */

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            if(mBoolLocation){
                Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
                sendBroadcast(closeDialog);
                FragmentManager fragmentManager = getSupportFragmentManager();
                ConnectionFragment connectionFragment = new ConnectionFragment();
                connectionFragment.show(fragmentManager, "Connection Fragment");
            }

        }
    }

    @Override
    public void connectionCallback() {
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case LOCATION_ON: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    recreate();

                } else {
                    Toast.makeText(this, R.string.maps_permission_deny, Toast.LENGTH_SHORT).show();
                    if (mNetworkInfo != null && mNetworkInfo.isConnected() == true) {
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
                        mBoolLocation = true;

                    }

                }


            }
        }


    }
}
