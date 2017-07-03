package com.realmucho.prokatproject.fragments.category_fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realmucho.prokatproject.adapters.CategoryAdapter;
import com.realmucho.prokatproject.adapters.CategoryTitleAdapter;
import com.realmucho.prokatproject.models.CategoryData;
import com.realmucho.prokatproject.interfaces.FragmentBackPressed;
import com.realmucho.prokatproject.interfaces.PaneCallBack;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;

public class GoodsCategoryFragment extends Fragment implements PaneCallBack, FragmentBackPressed {

    private SlidingPaneLayout slidingPaneLayout;
    private RecyclerView categoryrw;
    private RecyclerView categoryTitlerw;
    private CategoryAdapter adapter;
    private CategoryTitleAdapter titleAdapter;
    private TextView please;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goods_category_fragment, container, false);
        init(view);
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);
        categoryrw.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryTitlerw.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CategoryAdapter(setData(), getContext(), this);
        categoryrw.setAdapter(adapter);
        return view;
    }

    private void init(View view){

        slidingPaneLayout = (SlidingPaneLayout) view.findViewById(R.id.slidingPane);
        please = (TextView) view.findViewById(R.id.please);
        categoryrw = (RecyclerView) view.findViewById(R.id.goods_category_rw);
        categoryTitlerw = (RecyclerView) view.findViewById(R.id.subtitle_list);

    }


    private ArrayList<CategoryData> setData() {
        ArrayList<CategoryData> arrayList = new ArrayList<>();
        int[] checked = new int[]{R.drawable.pc_icon, R.drawable.birthday_cake_icon, R.drawable.dinamik_icon, R.drawable.camera_icon, R.drawable.build_icon, R.drawable.travel_icon, R.drawable.clothing_hanger_icon, R.drawable.heraxos_icon, R.drawable.ultimate_icon, R.drawable.aman_chaman_icon, R.drawable.tochki_icon};
        int[] unchecked = new int[]{R.drawable.pc_chacked_icon, R.drawable.birthday_cake_chacked_icon, R.drawable.dinamik_chacked_icon, R.drawable.camera_chacked_icon, R.drawable.build_chacked_icon, R.drawable.travel_chacked_icon, R.drawable.clothing_hanger_chacked_icon, R.drawable.heraxos_chacked_icon, R.drawable.ultimate_chacked_icon, R.drawable.aman_chaman_chacked_icon, R.drawable.tochki_checked_icon};
        String[] names = getResources().getStringArray(R.array.goods_titles);

        for (int i = 0; i < 11; i++) {
            arrayList.add(new CategoryData(unchecked[i], names[i + 1], checked[i]));

        }


        return arrayList;
    }


    @Override
    public void paneOpen(int position) {
        please.setVisibility(View.GONE);
        categoryTitlerw.setVisibility(View.VISIBLE);
        titleAdapter = new CategoryTitleAdapter(getContext(), getsubtitles().get(position));
        categoryTitlerw.setAdapter(titleAdapter);
        slidingPaneLayout.openPane();

    }


    private ArrayList<String[]> getsubtitles() {
        ArrayList<String[]> arrayList = new ArrayList<>();

        arrayList.add(getResources().getStringArray(R.array.comp_equipment_1));
        arrayList.add(getResources().getStringArray(R.array.ever_events_1));
        arrayList.add(getResources().getStringArray(R.array.sound_equipments_1));
        arrayList.add(getResources().getStringArray(R.array.cameras_1));
        arrayList.add(getResources().getStringArray(R.array.tools_1));
        arrayList.add(getResources().getStringArray(R.array.tourism_1));
        arrayList.add(getResources().getStringArray(R.array.clothing_1));
        arrayList.add(getResources().getStringArray(R.array.communications_1));
        arrayList.add(getResources().getStringArray(R.array.entertaiment_1));
        arrayList.add(getResources().getStringArray(R.array.tableware_1));
        arrayList.add(getResources().getStringArray(R.array.other_goods_1));

        return arrayList;
    }


    @Override
    public void closePane() {
        slidingPaneLayout.closePane();
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    if (slidingPaneLayout.isOpen()) {
                        slidingPaneLayout.closePane();
                    } else if (!slidingPaneLayout.isOpen()) {
                        getActivity().finish();
                    }

                    return true;

                }

                return false;
            }
        });
    }
}
