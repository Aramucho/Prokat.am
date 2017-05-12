package com.realmucho.prokatproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.realmucho.prokatproject.AddActivity;
import com.realmucho.prokatproject.MainActivity;
import com.realmucho.prokatproject.R;


public class MainFragment extends Fragment {

    //private FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_fragment,container,false);

        return view;
    }

//    @Override
//    public void onClick(View v) {
//        int id=v.getId();
//        Intent intent;
//        switch (id){
//            case R.id.fab:
//                intent=new Intent(getContext(), AddActivity.class);
//                startActivity(intent);
//                break;
//        }

    }

