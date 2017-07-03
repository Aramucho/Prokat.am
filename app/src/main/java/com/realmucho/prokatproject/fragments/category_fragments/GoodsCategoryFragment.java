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

    private SlidingPaneLayout mSlidingPaneLayout;
    private RecyclerView mCategoryRv;
    private RecyclerView mCategoryTitleRv;
    private CategoryAdapter mCategoryadapter;
    private CategoryTitleAdapter mTitleAdapter;
    private TextView mPlease;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goods_category_fragment, container, false);
        init(view);
        mSlidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);
        mCategoryRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryTitleRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryadapter = new CategoryAdapter(setData(), getContext(), this);
        mCategoryRv.setAdapter(mCategoryadapter);
        return view;
    }

    private void init(View view) {

        mSlidingPaneLayout = (SlidingPaneLayout) view.findViewById(R.id.slidingPane);
        mPlease = (TextView) view.findViewById(R.id.please);
        mCategoryRv = (RecyclerView) view.findViewById(R.id.goods_category_rw);
        mCategoryTitleRv = (RecyclerView) view.findViewById(R.id.subtitle_list);

    }


    private ArrayList<CategoryData> setData() {
        ArrayList<CategoryData> mArrayList = new ArrayList<>();
        int[] checked = new int[]{R.drawable.pc_icon, R.drawable.birthday_cake_icon, R.drawable.dinamik_icon, R.drawable.camera_icon, R.drawable.build_icon, R.drawable.travel_icon, R.drawable.clothing_hanger_icon, R.drawable.heraxos_icon, R.drawable.ultimate_icon, R.drawable.aman_chaman_icon, R.drawable.tochki_icon};
        int[] unchecked = new int[]{R.drawable.pc_chacked_icon, R.drawable.birthday_cake_chacked_icon, R.drawable.dinamik_chacked_icon, R.drawable.camera_chacked_icon, R.drawable.build_chacked_icon, R.drawable.travel_chacked_icon, R.drawable.clothing_hanger_chacked_icon, R.drawable.heraxos_chacked_icon, R.drawable.ultimate_chacked_icon, R.drawable.aman_chaman_chacked_icon, R.drawable.tochki_checked_icon};
        String[] names = getResources().getStringArray(R.array.goods_titles);

        for (int i = 0; i < 11; i++) {
            mArrayList.add(new CategoryData(unchecked[i], names[i + 1], checked[i]));

        }


        return mArrayList;
    }


    @Override
    public void paneopen(int position) {
        mPlease.setVisibility(View.GONE);
        mCategoryTitleRv.setVisibility(View.VISIBLE);
        mTitleAdapter = new CategoryTitleAdapter(getContext(), getSubTitles().get(position));
        mCategoryTitleRv.setAdapter(mTitleAdapter);
        mSlidingPaneLayout.openPane();

    }


    private ArrayList<String[]> getSubTitles() {
        ArrayList<String[]> mArrayList = new ArrayList<>();

        mArrayList.add(getResources().getStringArray(R.array.comp_equipment_1));
        mArrayList.add(getResources().getStringArray(R.array.ever_events_1));
        mArrayList.add(getResources().getStringArray(R.array.sound_equipments_1));
        mArrayList.add(getResources().getStringArray(R.array.cameras_1));
        mArrayList.add(getResources().getStringArray(R.array.tools_1));
        mArrayList.add(getResources().getStringArray(R.array.tourism_1));
        mArrayList.add(getResources().getStringArray(R.array.clothing_1));
        mArrayList.add(getResources().getStringArray(R.array.communications_1));
        mArrayList.add(getResources().getStringArray(R.array.entertaiment_1));
        mArrayList.add(getResources().getStringArray(R.array.tableware_1));
        mArrayList.add(getResources().getStringArray(R.array.other_goods_1));

        return mArrayList;
    }


    @Override
    public void closePane() {
        mSlidingPaneLayout.closePane();
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

                    if (mSlidingPaneLayout.isOpen()) {
                        mSlidingPaneLayout.closePane();
                    } else if (!mSlidingPaneLayout.isOpen()) {
                        getActivity().finish();
                    }

                    return true;

                }

                return false;
            }
        });
    }
}
