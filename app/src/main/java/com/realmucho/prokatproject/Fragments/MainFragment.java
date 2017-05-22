package com.realmucho.prokatproject.Fragments;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
        final Intent[] intent = new Intent[3];
        Handler handler;
        final int REQ_GOODS = 1;
        final int REQ_TRANSPORT = 2;
        final int REQ_SERVICE = 3;
        final int REQ_REALTY = 4;

        switch (id) {

            case R.id.goods_image:
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        intent[0] = new Intent(getContext(), CategoryActivity.class);
                        intent[0].putExtra("code", REQ_GOODS);
                        startActivity(intent[0]);
                    }
                }, 1000);


                break;
            case R.id.transport_image:
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent[1] = new Intent(getContext(), CategoryActivity.class);
                        intent[1].putExtra("code", REQ_TRANSPORT);
                        startActivity(intent[0]);
                    }
                }, 1000);

                break;
            case R.id.service_image:
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent[2] = new Intent(getContext(), CategoryActivity.class);
                        intent[2].putExtra("code", REQ_SERVICE);
                        startActivity(intent[0]);
                    }
                }, 1000);

                break;
            case R.id.realty_image:
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent[3] = new Intent(getContext(), CategoryActivity.class);
                        intent[3].putExtra("code", REQ_REALTY);
                        startActivity(intent[0]);
                    }
                }, 1000);

                break;


        }


    }

    public void animation(View view,ImageView imageView)
    {
        ObjectAnimator alphaAnimator=ObjectAnimator.ofFloat(view,"alpha",0f);
        alphaAnimator.setDuration(1500);
        ObjectAnimator scaleAnimatorX=ObjectAnimator.ofFloat(imageView,"scaleX",0f,(float)(imageView.getWidth()*2));
        scaleAnimatorX.setDuration(1500);
        ObjectAnimator scaleAnimatorY=ObjectAnimator.ofFloat(imageView,"scaleY",0f,(float)(imageView.getHeight()*2));
        scaleAnimatorX.setDuration(1500);
        AnimatorSet animatorSet= new AnimatorSet();
        animatorSet.play(scaleAnimatorX)
                .with(scaleAnimatorY)
                .after(alphaAnimator);
        animatorSet.start();

    }
}

