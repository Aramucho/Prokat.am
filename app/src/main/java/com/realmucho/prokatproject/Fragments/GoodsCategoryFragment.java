package com.realmucho.prokatproject.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.CategoryAdapter;
import com.realmucho.prokatproject.CategoryData;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;

public class GoodsCategoryFragment extends Fragment {

    private SlidingPaneLayout slidingPaneLayout;
    private RecyclerView categoryrw;
    private CategoryAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goods_category_fragment, container, false);
        slidingPaneLayout = (SlidingPaneLayout) view.findViewById(R.id.slidingPane);
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);

        categoryrw=(RecyclerView)view.findViewById(R.id.category_rw);
        categoryrw.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new CategoryAdapter(setData(),getContext());
        categoryrw.setAdapter(adapter);
        return view;
    }

    private ArrayList<CategoryData> setData(){
        ArrayList<CategoryData> arrayList=new ArrayList<>();
        int[] imagelist=new int[]{R.drawable.pc_chacked_icon,R.drawable.birthday_cake_chacked_icon,R.drawable.dinamik_chacked_icon,R.drawable.camera_chacked_icon,R.drawable.build_chacked_icon,R.drawable.travel_chacked_icon,R.drawable.clothing_hanger_chacked_icon,R.drawable.heraxos_chacked_icon,R.drawable.ultimate_chacked_icon,R.drawable.aman_chaman_chacked_icon,R.drawable.goods_chacked_icon};
        String[] names=getResources().getStringArray(R.array.goods_titles);

        for (int i = 0; i <11 ; i++) {
           arrayList.add(new CategoryData(imagelist[i],names[i+1]));
            
        }





        return arrayList;
    }


}
