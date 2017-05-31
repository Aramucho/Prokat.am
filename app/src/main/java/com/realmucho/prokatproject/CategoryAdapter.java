package com.realmucho.prokatproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private ArrayList<CategoryData> dataArrayList;
    private Context context;

    public CategoryAdapter(ArrayList<CategoryData> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryphoto;
        private TextView categoryname;
        private RelativeLayout relativeLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            categoryphoto = (ImageView) itemView.findViewById(R.id.category_photo);
            categoryname = (TextView) itemView.findViewById(R.id.category_text);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.item_layout);


        }


    }


    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item_view, parent, false);

        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(final CategoryAdapter.MyViewHolder holder, final int position) {
        final CategoryData categoryData = dataArrayList.get(position);
        holder.categoryname.setText(categoryData.getName());
        holder.categoryphoto.setImageResource(categoryData.getUncheckedphote());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                categoryData.clearall();

                holder.categoryphoto.setImageResource(categoryData.getCheckedphoto());
                holder.relativeLayout.setBackgroundResource(R.color.maincolorblue);
                holder.categoryname.setTextColor(context.getResources().getColor(R.color.maincolorwhite));
                switch (position) {
                    case 0:


                        break;
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }
}
