package com.realmucho.prokatproject.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.realmucho.prokatproject.interfaces.PaneCallBack;
import com.realmucho.prokatproject.models.ItemData;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;



public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.ItemListHolder> {
    private ArrayList<ItemData> mDataArrayList;
    private Context mContext;
    private PaneCallBack mPaneCallBack;
    private int mCurrentPosition = -1;//selected item's position



    public PostsListAdapter(ArrayList<ItemData> mDataArrayList, Context mContext,PaneCallBack mPaneCallBack) {
        this.mDataArrayList = mDataArrayList;
        this.mContext = mContext;
        this.mPaneCallBack = mPaneCallBack;
    }

    @Override
    public ItemListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.posts_list_item,parent,false);
        return new ItemListHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListHolder holder,final int position) {
        ItemData itemData= mDataArrayList.get(position);
        Glide.with(mContext).load(itemData.getMainImage()).centerCrop().into(holder.mainImage);
        holder.itemName.setText(itemData.getName());
        holder.price.setText(itemData.getmPrice());
        if (mCurrentPosition != -1 && position == mCurrentPosition) {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.maincolorblue));
            holder.linear.setBackgroundColor(mContext.getResources().getColor(R.color.maincolorwhite));
            holder.itemName.setTextColor(mContext.getResources().getColor(R.color.maincolorblue));
            holder.price.setTextColor(mContext.getResources().getColor(R.color.maincolorblue));

        } else {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.maincolorwhite));
            holder.linear.setBackgroundColor(mContext.getResources().getColor(R.color.maincolorblue));
            holder.itemName.setTextColor(mContext.getResources().getColor(R.color.maincolorwhite));
            holder.price.setTextColor(mContext.getResources().getColor(R.color.maincolorwhite));

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentPosition = position;
                notifyDataSetChanged();
                mPaneCallBack.paneOpen(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mDataArrayList.size();
    }


    public class ItemListHolder extends RecyclerView.ViewHolder{

        ImageView mainImage;
        TextView itemName, price;
        CardView cardView;
        LinearLayout linear;


        public ItemListHolder(View itemView) {
            super(itemView);
            mainImage=(ImageView) itemView.findViewById(R.id.mainImage);
            itemName=(TextView)itemView.findViewById(R.id.name);
            price=(TextView)itemView.findViewById(R.id.mPrice);
            cardView=(CardView)itemView.findViewById(R.id.card_view);
            linear=(LinearLayout)itemView.findViewById(R.id.linear);
        }
    }
}

