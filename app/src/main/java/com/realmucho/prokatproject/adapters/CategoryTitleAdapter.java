package com.realmucho.prokatproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realmucho.prokatproject.activities.PostsActivity;

import com.realmucho.prokatproject.R;

/**The adapter for CategoryTitleRv*/

public class CategoryTitleAdapter extends RecyclerView.Adapter<CategoryTitleAdapter.TitleViewHolder> {
    private Context mContext;
    private String[] mTitlesData;
    private int mCurrentPosition =-1; //position of selected item



    public CategoryTitleAdapter(Context mContext, String[] mTitlesData) {
        this.mContext = mContext;
        this.mTitlesData = mTitlesData;

    }

    @Override
    public TitleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.title_rv_item, viewGroup,false);
        return new TitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TitleViewHolder holder,final int position) {
        holder.title.setText(mTitlesData[position]);
        if(mCurrentPosition !=-1 && position== mCurrentPosition){
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.maincolorwhite));
            holder.title.setTextColor(mContext.getResources().getColor(R.color.maincolorblue));
        }else{
            holder.layout.setBackgroundColor(mContext.getResources().getColor(R.color.maincolorblue));
            holder.title.setTextColor(mContext.getResources().getColor(R.color.maincolorwhite));
        }

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentPosition =position;
                notifyDataSetChanged();
                Intent intent=new Intent(mContext, PostsActivity.class);
                intent.getIntExtra("request",position);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTitlesData.length;
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
