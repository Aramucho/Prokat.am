package com.realmucho.prokatproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realmucho.prokatproject.R;


public class RealtyFragment extends Fragment {

    private TextView section;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.realty_fragment, container, false);
        section = (TextView) view.findViewById(R.id.realty_section);
        section.setFocusableInTouchMode(true);
        section.requestFocus();
        return view;
    }
}
