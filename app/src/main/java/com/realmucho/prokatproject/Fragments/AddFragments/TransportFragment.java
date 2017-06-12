package com.realmucho.prokatproject.Fragments.AddFragments;

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


public class TransportFragment extends Fragment {

    private TextView section;
    private Spinner transportsectionspinner,fueltypespinner,boxspinner;
    private ArrayAdapter tranportsectionadapter,fueltypeadapter,boxadapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.transport_fragment,container,false);
        section=(TextView)view.findViewById(R.id.transport_section);
        section.setFocusableInTouchMode(true);
        section.requestFocus();
        transportsectionspinner=(Spinner)view.findViewById(R.id.transport_section_spinner);
        fueltypespinner=(Spinner)view.findViewById(R.id.transport_fuel_type_spinner);
        boxspinner=(Spinner)view.findViewById(R.id.transport_box_spinner);
        spininit();
        return  view;
    }

    private void spininit(){
        tranportsectionadapter=ArrayAdapter.createFromResource(getContext(),R.array.transport_titles,R.layout.drop_down_spinner_item);
        transportsectionspinner.setAdapter(tranportsectionadapter);
        fueltypeadapter=ArrayAdapter.createFromResource(getContext(),R.array.fuel_types,R.layout.drop_down_spinner_item);
        fueltypespinner.setAdapter(fueltypeadapter);
        boxadapter=ArrayAdapter.createFromResource(getContext(),R.array.box_types,R.layout.drop_down_spinner_item);
        boxspinner.setAdapter(boxadapter);
    }
}
