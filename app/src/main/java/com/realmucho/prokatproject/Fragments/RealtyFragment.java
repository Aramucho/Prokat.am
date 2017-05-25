package com.realmucho.prokatproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.realmucho.prokatproject.R;


public class RealtyFragment extends Fragment {

    private TextView section;
    private Spinner realtyspinner;
    private ArrayAdapter realtyspinneradpater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.realty_fragment, container, false);
        section = (TextView) view.findViewById(R.id.realty_section);
        section.setFocusableInTouchMode(true);
        section.requestFocus();
        realtyspinner = (Spinner) view.findViewById(R.id.realty_section_spinner);
        spinnerinit();
        return view;
    }

    private void spinnerinit() {

        realtyspinneradpater = ArrayAdapter.createFromResource(getContext(), R.array.realty_items, R.layout.drop_down_spinner_item);
        realtyspinner.setAdapter(realtyspinneradpater);
    }
}
