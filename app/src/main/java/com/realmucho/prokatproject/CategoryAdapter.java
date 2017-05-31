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
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, final int position) {
        CategoryData categoryData = dataArrayList.get(position);
        holder.categoryname.setText(categoryData.getName());
        holder.categoryphoto.setImageResource(categoryData.getPhoto());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position)
                {
                    case 0:
                        Toast.makeText(context,"Click1",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context,"Click2",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context,"Click3",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(context,"Click4",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(context,"Click4",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(context,"Click4",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(context,"Click4",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(context,"Click4",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(context,"Click4",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(context,"Click4",Toast.LENGTH_SHORT).show();
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
