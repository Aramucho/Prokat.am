package com.realmucho.prokatproject.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
//        section = (TextView) view.findViewById(R.id.goods_section);
//        section.setFocusableInTouchMode(true);
//        section.requestFocus();

        sectionspinner = (Spinner) view.findViewById(R.id.goods_section_spinner);
        goodssubsectionspinner = (Spinner) view.findViewById(R.id.goods_subsection_spinner);
        goodscitiesspinner = (Spinner) view.findViewById(R.id.goods_cities_spinner);

        spinnersinit();


        return view;
    }

    private void spinnersinit() {

        sectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.goods_titles, R.layout.drop_down_spinner_item);
        goodscitiesadapter=ArrayAdapter.createFromResource(getContext(),R.array.cities,R.layout.drop_down_spinner_item);

        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.bydefualt, R.layout.drop_down_spinner_item);
        sectionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {


                    case 1:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.comp_equipment, R.layout.drop_down_spinner_item);
                        ;

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 2:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.ever_events, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 3:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.sound_equipments, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 4:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.cameras, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 5:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.tools, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 6:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.tourism, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 7:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.clothing, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 8:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.communications, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 9:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.entertaiment, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 10:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.tableware, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;
                    case 11:
                        goodsubsectionadapter = ArrayAdapter.createFromResource(getContext(), R.array.other_goods, R.layout.drop_down_spinner_item);

                        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sectionspinner.setAdapter(sectionadapter);
        goodssubsectionspinner.setAdapter(goodsubsectionadapter);
        goodscitiesspinner.setAdapter(goodscitiesadapter);


    }


}
