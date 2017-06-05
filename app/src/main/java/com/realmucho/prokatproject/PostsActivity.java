package com.realmucho.prokatproject;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.realmucho.prokatproject.Interfaces.PaneCallBack;

import java.util.ArrayList;

public class PostsActivity extends AppCompatActivity implements PaneCallBack {

    private SlidingPaneLayout slidingPaneLayout;
    private RecyclerView recyclerView;
    private PostsListAdapter adapter;
    private MaterialRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts_activity);
        refreshLayout=(MaterialRefreshLayout)findViewById(R.id.refreshlayout);
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.posts_sliding_pane);
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);
        recyclerView = (RecyclerView) findViewById(R.id.itemList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new PostsListAdapter(setItemData(), this,this);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<ItemData> setItemData() {
        ArrayList<ItemData> arrayList = new ArrayList<>();
        int[] array = {R.drawable.bad, R.drawable.bird, R.drawable.bird2, R.drawable.katil};
        String[] names = {"BAD", "BIRD", "BIRD2", "KATIL"};
        String[] prices = {"1500", "1500", "1500", "1500"};
        for (int i = 0; i < 4; i++) {
            ItemData itemData = new ItemData(array[i], names[i], prices[i]);
            arrayList.add(itemData);
        }

        return arrayList;
    }


    @Override
    protected void onResume() {
        super.onResume();
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                    }
                },1000);
            }
        });
    }

    @Override
    public void paneopen(int position) {
        slidingPaneLayout.openPane();
    }
}
