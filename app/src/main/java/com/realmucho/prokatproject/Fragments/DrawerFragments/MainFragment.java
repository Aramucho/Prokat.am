package com.realmucho.prokatproject.Fragments.DrawerFragments;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.realmucho.prokatproject.Activities.AddActivity;
import com.realmucho.prokatproject.Activities.CategoryActivity;
import com.realmucho.prokatproject.Interfaces.DisableOnClick;
import com.realmucho.prokatproject.R;
import java.util.HashMap;
import java.util.Map;


public class MainFragment extends Fragment implements View.OnClickListener {

    private ImageView goodsimage, transportimage, serviceimage, realtyimage, roundcategory;
    private View pizza;
    private Intent intent;
    private Handler handler;
    private Map<String, Integer> imagesround;
    private FloatingActionButton add;
    private RelativeLayout mainlayout;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        pizza = view.findViewById(R.id.pizza);
        mainlayout=(RelativeLayout)view.findViewById(R.id.main_fragment_layout);
        roundcategory = (ImageView) view.findViewById(R.id.roundcategory);
        goodsimage = (ImageView) view.findViewById(R.id.goods_image);
        transportimage = (ImageView) view.findViewById(R.id.transport_image);
        serviceimage = (ImageView) view.findViewById(R.id.service_image);
        realtyimage = (ImageView) view.findViewById(R.id.realty_image);
        add = (FloatingActionButton) view.findViewById(R.id.fab);
        add.setOnClickListener(this);
        goodsimage.setOnClickListener(this);
        transportimage.setOnClickListener(this);
        serviceimage.setOnClickListener(this);
        realtyimage.setOnClickListener(this);
        imagesround = new HashMap<>();
        imagesround.put("goods", R.drawable.goods_round);
        imagesround.put("transport", R.drawable.transport_round);
        imagesround.put("service", R.drawable.service_round);
        imagesround.put("realty", R.drawable.realty_round);
        roundcategory.setVisibility(View.GONE);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        final int REQ_GOODS = 1;
        final int REQ_TRANSPORT = 2;
        final int REQ_SERVICE = 3;
        final int REQ_REALTY = 4;

        switch (id) {

            case R.id.goods_image:
                roundcategory.setImageResource(imagesround.get("goods"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();
                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_GOODS);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.transport_image:
                roundcategory.setImageResource(imagesround.get("transport"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();

                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_TRANSPORT);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.service_image:
                roundcategory.setImageResource(imagesround.get("service"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();

                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_SERVICE);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.realty_image:
                roundcategory.setImageResource(imagesround.get("realty"));
                roundcategory.setVisibility(View.VISIBLE);
                animation(pizza, roundcategory);
                handler = new Handler();

                handler.postDelayed(new Runnable() {


                    @Override
                    public void run() {

                        pizza.setVisibility(View.GONE);
                        intent = new Intent(getContext(), CategoryActivity.class);
                        intent.putExtra("code", REQ_REALTY);
                        startActivity(intent);
                    }
                }, 1200);


                break;
            case R.id.fab:
                intent = new Intent(getContext(), AddActivity.class);
                startActivity(intent);
                break;


        }


    }

    public void animation(View view, ImageView imageView) {

        ObjectAnimator alphaAnimatorPizza = ObjectAnimator.ofFloat(view, "alpha", 0f);
        alphaAnimatorPizza.setDuration(500);
        ObjectAnimator alphaAnimatorRound = ObjectAnimator.ofFloat(imageView, "alpha", 1f);
        alphaAnimatorRound.setDuration(500);

        alphaAnimatorRound.setStartDelay(600);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimatorPizza, alphaAnimatorRound);
        animatorSet.start();


    }


    @Override
    public void onResume() {


        super.onResume();
        pizza.setAlpha(1);
        pizza.setVisibility(View.VISIBLE);
        roundcategory.setAlpha(0f);
        roundcategory.setVisibility(View.GONE);

    }

    public void disableClicks(){
        mainlayout.setClickable(false);
    }



}

