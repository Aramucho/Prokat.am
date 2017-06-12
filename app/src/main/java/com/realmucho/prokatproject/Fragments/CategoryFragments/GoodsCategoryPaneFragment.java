package com.realmucho.prokatproject.Fragments.CategoryFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.R;

public class GoodsCategoryPaneFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.goods_category_pane_fragment,container,false);
        return view;
    }
}
