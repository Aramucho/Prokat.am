package com.realmucho.prokatproject.Fragments;

import android.content.Context;
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


    private Spinner sectionspinner, goodssubsectionspinner, goodscitiesspinner;
    private ArrayAdapter sectionadapter, goodsubsectionadapter, goodscitiesadapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gooods_fragment, container, false);
        section = (TextView) view.findViewById(R.id.goods_section);
        section.setFocusableInTouchMode(true);
        section.requestFocus();
        sectionspinner = (Spinner) view.findViewById(R.id.goods_section_spinner);
        goodssubsectionspinner = (Spinner) view.findViewById(R.id.goods_subsection_spinner);
        goodscitiesspinner = (Spinner) view.findViewById(R.id.goods_cities_spinner);
        sectionspinner.setPrompt("aaaa");
        spinnersinit();


        return view;
    }

    private void spinnersinit() {
        String[] sectiontitles = getResources().getStringArray(R.array.goods_titles);
        final String[] compequipments = getResources().getStringArray(R.array.comp_equipment);
        final String[] everevents = getResources().getStringArray(R.array.ever_events);
        final String[] soundequip = getResources().getStringArray(R.array.sound_equipments);
        final String[] cameras = getResources().getStringArray(R.array.cameras);

        sectionadapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, sectiontitles);

        sectionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {


                    case 1:
                        goodsubsectionadapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, compequipments);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 2:
                        goodsubsectionadapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, everevents);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 3:
                        goodsubsectionadapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, soundequip);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 4:
                        goodsubsectionadapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, cameras);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sectionspinner.setAdapter(sectionadapter);


    }


}
