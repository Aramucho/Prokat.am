package com.realmucho.prokatproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realmucho.prokatproject.R;


public class ServiceFragment extends Fragment {
    private TextView price;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.service_fragment,container,false);
        price=(TextView)view.findViewById(R.id.service_price);
        price.setFocusableInTouchMode(true);
        price.requestFocus();
        return view;
    }
}
