package com.realmucho.prokatproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.realmucho.prokatproject.CategoryActivity;
import com.realmucho.prokatproject.R;


public class MainFragment extends Fragment implements View.OnClickListener {

    private ImageView goodsimage, transportimage, serviceimage, realtyimage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        goodsimage = (ImageView) view.findViewById(R.id.goods_image);
        transportimage = (ImageView) view.findViewById(R.id.transport_image);
        serviceimage = (ImageView) view.findViewById(R.id.service_image);
        realtyimage = (ImageView) view.findViewById(R.id.realty_image);
        goodsimage.setOnClickListener(this);
        transportimage.setOnClickListener(this);
        serviceimage.setOnClickListener(this);
        realtyimage.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        final int REQ_GOODS=1;
        final int REQ_TRANSPORT=2;
        final int REQ_SERVICE=3;
        final int REQ_REALTY=4;

        switch (id) {

            case R.id.goods_image:
                intent = new Intent(getContext(), CategoryActivity.class);
                intent.putExtra("code",REQ_GOODS);
                startActivity(intent);
                break;
            case R.id.transport_image:
                intent = new Intent(getContext(), CategoryActivity.class);
                intent.putExtra("code",REQ_TRANSPORT);
                startActivity(intent);
                break;
            case R.id.service_image:
                intent = new Intent(getContext(), CategoryActivity.class);
                intent.putExtra("code",REQ_SERVICE);
                startActivity(intent);
                break;
            case R.id.realty_image:
                intent = new Intent(getContext(), CategoryActivity.class);
                intent.putExtra("code",REQ_REALTY);
                startActivity(intent);
                break;


        }


    }
}

