package com.realmucho.prokatproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.realmucho.prokatproject.models.CategoryData;
import com.realmucho.prokatproject.interfaces.PaneCallBack;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private ArrayList<CategoryData> dataArrayList;
    private Context context;
    private PaneCallBack paneCallBack;
    private int curPosition = -1;

    public CategoryAdapter(ArrayList<CategoryData> dataArrayList, Context context,PaneCallBack paneCallBack) {
        this.dataArrayList = dataArrayList;
        this.context = context;
        this.paneCallBack=paneCallBack;

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
        if (curPosition != -1 && position == curPosition) {
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.maincolorblue));
            holder.categoryphoto.setBackgroundResource(categoryData.getmCheckedPhoto());
            holder.categoryname.setTextColor(context.getResources().getColor(R.color.maincolorwhite));

        } else {
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.maincolorwhite));
            holder.categoryphoto.setBackgroundResource(categoryData.getUncheckedphote());
            holder.categoryname.setTextColor(context.getResources().getColor(R.color.maincolorblue));

        }
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
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

}