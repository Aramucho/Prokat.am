package com.realmucho.prokatproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.CategoryAdapter;
import com.realmucho.prokatproject.CategoryData;
import com.realmucho.prokatproject.Interfaces.PaneCallBack;
import com.realmucho.prokatproject.PostsActivity;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;


public class ServiceCategoryFragment extends Fragment implements PaneCallBack {
    private RecyclerView categoryrw;
    private CategoryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.service_category_fragment,container,false);
        categoryrw = (RecyclerView) view.findViewById(R.id.service_category_rw);
        categoryrw.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CategoryAdapter(setData(), getContext(), this);
        categoryrw.setAdapter(adapter);
        return view;
    }
    private ArrayList<CategoryData> setData() {
        ArrayList<CategoryData> arrayList = new ArrayList<>();
        int[] checked = new int[]{R.drawable.pc_icon, R.drawable.birthday_cake_icon, R.drawable.dinamik_icon, R.drawable.camera_icon, R.drawable.build_icon, R.drawable.travel_icon, R.drawable.clothing_hanger_icon, R.drawable.heraxos_icon, R.drawable.ultimate_icon, R.drawable.aman_chaman_icon, R.drawable.goods_icon};
        int[] unchecked = new int[]{R.drawable.pc_chacked_icon, R.drawable.birthday_cake_chacked_icon, R.drawable.dinamik_chacked_icon, R.drawable.camera_chacked_icon, R.drawable.build_chacked_icon, R.drawable.travel_chacked_icon, R.drawable.clothing_hanger_chacked_icon, R.drawable.heraxos_chacked_icon, R.drawable.ultimate_chacked_icon, R.drawable.aman_chaman_chacked_icon, R.drawable.goods_chacked_icon};
        String[] names = getResources().getStringArray(R.array.goods_titles);

        for (int i = 0; i < 11; i++) {
            arrayList.add(new CategoryData(unchecked[i], names[i + 1], checked[i]));

        }


        return arrayList;
    }

    @Override
    public void paneopen(int position) {
        Intent intent=new Intent(getContext(), PostsActivity.class);
        startActivity(intent);
    }
}
