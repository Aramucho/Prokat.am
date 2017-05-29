package com.realmucho.prokatproject.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.R;

public class GoodsCategoryFragment extends Fragment {

    SlidingPaneLayout slidingPaneLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.goods_category_fragment,container,false);
        slidingPaneLayout=(SlidingPaneLayout)view.findViewById(R.id.slidingPane);
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);
        return view;
    }
}
