package com.realmucho.prokatproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realmucho.prokatproject.Activities.PostsActivity;

import com.realmucho.prokatproject.R;


public class CategoryTitleAdapter extends RecyclerView.Adapter<CategoryTitleAdapter.TitleViewHolder> {
    private Context context;
    private String[] titlesdata;
    private int curposition=-1;



    public CategoryTitleAdapter(Context context, String[] titlesdata) {
        this.context = context;
        this.titlesdata = titlesdata;

    }

    @Override
    public TitleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.title_rv_item, viewGroup,false);

        return new TitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TitleViewHolder holder,final int position) {
        holder.title.setText(titlesdata[position]);
        if(curposition!=-1 && position==curposition){
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.maincolorwhite));
            holder.title.setTextColor(context.getResources().getColor(R.color.maincolorblue));
        }else{
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.maincolorblue));
            holder.title.setTextColor(context.getResources().getColor(R.color.maincolorwhite));
        }

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curposition=position;
                notifyDataSetChanged();
                Intent intent=new Intent(context, PostsActivity.class);
                intent.getIntExtra("request",position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return titlesdata.length;
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private RelativeLayout  layout;


        public TitleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            layout=(RelativeLayout)itemView.findViewById(R.id.item_back);

        }


    }
}
