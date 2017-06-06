package com.realmucho.prokatproject;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class ItemPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemPagerAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }





    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    int[] array = {R.drawable.bird, R.drawable.bird2, R.drawable.katil, R.drawable.bird};

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView=layoutInflater.inflate(R.layout.pager_item,container,false);
        ImageView imageView=(ImageView) itemView.findViewById(R.id.item_image);
        Glide.with(context).load(array[position]).centerCrop().into(imageView);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
    @Override
    public int getCount() {
        return array.length;
    }
}
