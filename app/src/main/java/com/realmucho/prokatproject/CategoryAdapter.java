package com.realmucho.prokatproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.realmucho.prokatproject.Interfaces.IconChangeCallback;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private ArrayList<CategoryData> dataArrayList;
    private Context context;

    public CategoryAdapter(ArrayList<CategoryData> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements IconChangeCallback  {

        private ImageView categoryphoto,categoryphoto_fake;
        private TextView categoryname;

        public MyViewHolder(View itemView) {
            super(itemView);
            categoryphoto=(ImageView)itemView.findViewById(R.id.category_photo);
            categoryname=(TextView)itemView.findViewById(R.id.category_text);
            categoryphoto_fake=(ImageView)itemView.findViewById(R.id.category_photo_fake);
        }
        @Override
        public void changeIcon(int i) {
            if(i==1){
                categoryphoto.setVisibility(View.GONE);
                categoryphoto_fake.setVisibility(View.VISIBLE);
            }
            else{
                categoryphoto.setVisibility(View.VISIBLE);
                categoryphoto_fake.setVisibility(View.GONE);
            }
        }



    }


    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.category_item_view,parent,false);

        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
                  CategoryData categoryData=dataArrayList.get(position);
                  holder.categoryname.setText(categoryData.getName());
                  holder.categoryphoto.setImageResource(categoryData.getPhoto());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }
}
