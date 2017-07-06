package com.realmucho.prokatproject.fragments.category_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realmucho.prokatproject.adapters.CategoryAdapter;
import com.realmucho.prokatproject.models.CategoryData;
import com.realmucho.prokatproject.interfaces.PaneCallBack;
import com.realmucho.prokatproject.activities.PostsActivity;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;


public class ServiceCategoryFragment extends Fragment implements PaneCallBack {
    private RecyclerView mCategoryRv;
    private CategoryAdapter mCategoryAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.service_category_fragment,container,false);
        mCategoryRv = (RecyclerView) view.findViewById(R.id.service_category_rw);
        mCategoryRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryAdapter = new CategoryAdapter(setData(), getContext(), this);
        mCategoryRv.setAdapter(mCategoryAdapter);
        return view;
    }

    /**Setting local data for testing recyclerViews*/
    private ArrayList<CategoryData> setData() {
        ArrayList<CategoryData> arrayList = new ArrayList<>();
        int[] checked = new int[]{R.drawable.hars_pesa_chacked_icon, R.drawable.vfx_chacked_icon, R.drawable.celebration_chacked_icon,  R.drawable.furshet_chacked_icon, R.drawable.aficant_chacked_icon, R.drawable.balloons_chacked_icon, R.drawable.kids_chacked_icon, R.drawable.pcservice_chacked_icon, R.drawable.shinarar_chacked_icon, R.drawable.tochki_checked_icon};
        int[] unchecked = new int[]{R.drawable.hars_pesa_icon, R.drawable.vfx_icon, R.drawable.celebration_icon,  R.drawable.furshet_icon, R.drawable.aficant_icon, R.drawable.balloons_icon, R.drawable.kids_icon, R.drawable.pcservice_icon, R.drawable.shinarar_icon, R.drawable.tochki_icon};
        String[] names = getResources().getStringArray(R.array.service_items);

        for (int i = 0; i < 10; i++) {
            arrayList.add(new CategoryData(checked[i], names[i + 1], unchecked[i]));

        }

        return arrayList;
    }

    @Override
    public void paneOpen(int position) {
        Intent intent=new Intent(getContext(), PostsActivity.class);
        intent.putExtra("request",position);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){


                    getActivity().finish();


                    return true;

                }

                return false;
            }
        });
    }

}
