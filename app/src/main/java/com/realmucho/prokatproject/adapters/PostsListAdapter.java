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
    private ArrayList<ItemData> dataArrayList;
    private Context context;
    private int curPosition = -1;
    private PaneCallBack paneCallBack;

    public PostsListAdapter(ArrayList<ItemData> dataArrayList, Context context,PaneCallBack paneCallBack) {
        this.dataArrayList = dataArrayList;
        this.context = context;
        this.paneCallBack=paneCallBack;
    }

    @Override
    public ItemListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.posts_list_item,parent,false);
        return new ItemListHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListHolder holder,final int position) {
        ItemData itemData=dataArrayList.get(position);
        Glide.with(context).load(itemData.getMainImage()).centerCrop().into(holder.mainImage);
        holder.itemName.setText(itemData.getItemName());
        holder.price.setText(itemData.getPrice());
        if (curPosition != -1 && position == curPosition) {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.maincolorblue));
            holder.linear.setBackgroundColor(context.getResources().getColor(R.color.maincolorwhite));
            holder.itemName.setTextColor(context.getResources().getColor(R.color.maincolorblue));
            holder.price.setTextColor(context.getResources().getColor(R.color.maincolorblue));

        } else {
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.maincolorwhite));
            holder.linear.setBackgroundColor(context.getResources().getColor(R.color.maincolorblue));
            holder.itemName.setTextColor(context.getResources().getColor(R.color.maincolorwhite));
            holder.price.setTextColor(context.getResources().getColor(R.color.maincolorwhite));

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curPosition = position;
                notifyDataSetChanged();
                paneCallBack.paneopen(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }


    public class ItemListHolder extends RecyclerView.ViewHolder{

        ImageView mainImage;
        TextView itemName, price;
        CardView cardView;
        LinearLayout linear;


        public ItemListHolder(View itemView) {
            super(itemView);
            mainImage=(ImageView) itemView.findViewById(R.id.mainImage);
            itemName=(TextView)itemView.findViewById(R.id.itemName);
            price=(TextView)itemView.findViewById(R.id.price);
            cardView=(CardView)itemView.findViewById(R.id.card_view);
            linear=(LinearLayout)itemView.findViewById(R.id.linear);
        }
    }
}

