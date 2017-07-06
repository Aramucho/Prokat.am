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

/**The adapter for CategoryRv*/

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private ArrayList<CategoryData> mDataArrayList;
    private Context mContext;
    private PaneCallBack mPaneCallBack;
    private int mCurrentPosition = -1; //position of selected item

    public CategoryAdapter(ArrayList<CategoryData> mDataArrayList, Context mContext,PaneCallBack mPaneCallBack) {
        this.mDataArrayList = mDataArrayList;
        this.mContext = mContext;
        this.mPaneCallBack = mPaneCallBack;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mCategoryPhoto;
        private TextView mCategoryName;
        private RelativeLayout mRelativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            mCategoryPhoto = (ImageView) itemView.findViewById(R.id.category_photo);
            mCategoryName = (TextView) itemView.findViewById(R.id.category_text);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.item_layout);
        }

    }


    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_item_view, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final CategoryAdapter.MyViewHolder holder, final int position) {
        final CategoryData categoryData = mDataArrayList.get(position);
        holder.mCategoryName.setText(categoryData.getName());
        if (mCurrentPosition != -1 && position == mCurrentPosition) {
            holder.mRelativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.maincolorblue));
            holder.mCategoryPhoto.setBackgroundResource(categoryData.getmCheckedPhoto());
            holder.mCategoryName.setTextColor(mContext.getResources().getColor(R.color.maincolorwhite));

        } else {
            holder.mRelativeLayout.setBackgroundColor(mContext.getResources().getColor(R.color.maincolorwhite));
            holder.mCategoryPhoto.setBackgroundResource(categoryData.getUncheckedphote());
            holder.mCategoryName.setTextColor(mContext.getResources().getColor(R.color.maincolorblue));

        }
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
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

}