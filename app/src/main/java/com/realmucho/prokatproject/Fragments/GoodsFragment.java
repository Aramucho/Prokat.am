package com.realmucho.prokatproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.realmucho.prokatproject.R;


public class GoodsFragment extends Fragment {

    private TextView section;

    private Spinner spinner;
    private ArrayAdapter adapter;
    private String[] strings ={"asdad","asdsada","asdada","asdasda","asdasda"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gooods_fragment, container, false);

        section = (TextView) view.findViewById(R.id.goods_section);
        section.setFocusableInTouchMode(true);
        section.requestFocus();
        spinner=(Spinner)view.findViewById(R.id.goods_section_spinner);
        adapter=new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,strings);
        spinner.setAdapter(adapter);

        return view;
    }


}
