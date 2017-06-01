package com.realmucho.prokatproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.ItemListHolder> {
    private ArrayList<ItemData> dataArrayList;
    private Context context;

    public PostsListAdapter(ArrayList<ItemData> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @Override
    public ItemListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.posts_list_item,parent,false);
        return new ItemListHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListHolder holder, int position) {
        ItemData itemData=dataArrayList.get(position);
        Picasso.with(context).load(itemData.getMainImage()).fit().into(holder.mainImage);
        holder.itemName.setText(itemData.getItemName());
        holder.price.setText(itemData.getPrice());

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }


    public class ItemListHolder extends RecyclerView.ViewHolder{

        ImageView mainImage;
        TextView itemName, price;

        public ItemListHolder(View itemView) {
            super(itemView);
            mainImage=(ImageView) itemView.findViewById(R.id.mainImage);
            itemName=(TextView)itemView.findViewById(R.id.itemName);
            price=(TextView)itemView.findViewById(R.id.price);

        }
    }
}

