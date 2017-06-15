package com.realmucho.prokatproject.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.realmucho.prokatproject.Fragments.DialogFragments.OrderDialogFragment;
import com.realmucho.prokatproject.Interfaces.PaneCallBack;
import com.realmucho.prokatproject.Models.ItemData;
import com.realmucho.prokatproject.Adapters.ItemPagerAdapter;
import com.realmucho.prokatproject.Adapters.PostsListAdapter;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class PostsActivity extends AppCompatActivity implements PaneCallBack, View.OnClickListener {

    private SlidingPaneLayout slidingPaneLayout;
    private RecyclerView recyclerView;
    private PostsListAdapter adapter;
    private MaterialRefreshLayout refreshLayout;
    private GridLayoutManager layoutManager;
    private ViewPager viewPager;
    private ItemPagerAdapter pageradapter;
    private ImageButton scroll;
    private CircleIndicator indicator;
    private Button order, relatives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts_activity);
        viewPager = (ViewPager) findViewById(R.id.detailed_pager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        scroll = (ImageButton) findViewById(R.id.scroll_up);
        pageradapter = new ItemPagerAdapter(this);
        viewPager.setAdapter(pageradapter);
        indicator.setViewPager(viewPager);
        indicator.animate().rotation(180);
        order = (Button) findViewById(R.id.order);
        relatives = (Button) findViewById(R.id.relatives);
        order.setOnClickListener(this);
        relatives.setOnClickListener(this);
        pageradapter.registerDataSetObserver(indicator.getDataSetObserver());
        refreshLayout = (MaterialRefreshLayout) findViewById(R.id.refreshlayout);
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.posts_sliding_pane);
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);
        recyclerView = (RecyclerView) findViewById(R.id.itemList);
        layoutManager = new GridLayoutManager(this, 2);
        layoutManager.scrollToPositionWithOffset(2, 20);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostsListAdapter(setItemData(), this, this);
        recyclerView.setAdapter(adapter);
        scrollinit();

    }

    private void scrollinit() {
        scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                layoutManager.scrollToPositionWithOffset(0, 0);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int firstposition = layoutManager.findFirstVisibleItemPosition();
                if (firstposition != 0) {
                    scroll.setVisibility(View.VISIBLE);
                } else {
                    scroll.setVisibility(View.GONE);
                }
            }
        });
    }


    private ArrayList<ItemData> setItemData() {
        ArrayList<ItemData> arrayList = new ArrayList<>();
        int[] array = {R.drawable.bad, R.drawable.bird, R.drawable.bird2, R.drawable.katil, R.drawable.bad, R.drawable.bird, R.drawable.bird2, R.drawable.katil, R.drawable.bird2, R.drawable.katil};
        String[] names = {"BAD", "BIRD", "BIRD2", "KATIL", "BIRD", "BIRD2", "KATIL", "BIRD", "BIRD2", "KATIL"};
        String[] prices = {"1500", "1500", "1500", "1500", "1500", "1500", "1500", "1500", "1500", "1500"};
        for (int i = 0; i < names.length; i++) {
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
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                    }
                }, 1000);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent reqintent = getIntent();
        Intent intent;


        if (slidingPaneLayout.isOpen()) {
            slidingPaneLayout.closePane();
        } else if (!slidingPaneLayout.isOpen()) {
            if (reqintent.getIntExtra("req_top", 5) == 0) {
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            } else if (reqintent.getIntExtra("req_new", 5) == 1) {
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else {

                super.onBackPressed();

            }
        }

    }

    @Override
    public void paneopen(int position) {
        slidingPaneLayout.openPane();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.order:
                FragmentManager fragmentManager = getSupportFragmentManager();
                OrderDialogFragment dialogFragment = new OrderDialogFragment();
                dialogFragment.show(fragmentManager, "Sample Fragment");
                break;
            case R.id.relatives:
                Intent intent = new Intent(PostsActivity.this, PostsActivity.class);
                startActivity(intent);
                break;
        }

    }
}
