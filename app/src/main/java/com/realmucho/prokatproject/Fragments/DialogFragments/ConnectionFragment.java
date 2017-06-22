package com.realmucho.prokatproject.Fragments.DialogFragments;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.realmucho.prokatproject.Activities.SplashScreen;
import com.realmucho.prokatproject.Interfaces.ConnectionCallback;
import com.realmucho.prokatproject.R;


public class ConnectionFragment extends DialogFragment implements View.OnClickListener {
    private Button cancelbtn, retrybtn;
    private ConnectionCallback connectionCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.connection_dialog, container, false);
        cancelbtn = (Button) view.findViewById(R.id.cancel_btn);
        retrybtn = (Button) view.findViewById(R.id.retry_btn);
        cancelbtn.setOnClickListener(this);
        retrybtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.cancel_btn:
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);

                break;
            case R.id.retry_btn:
                ConnectivityManager ConnectionManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
                if(networkInfo != null && networkInfo.isConnected() == true){
                    getDialog().dismiss();
                    connectionCallback.conncallback();

                }
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.connectionCallback=(ConnectionCallback)context;
    }
}
