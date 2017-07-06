package com.realmucho.prokatproject.activities;

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
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.realmucho.prokatproject.fragments.dialog_fragments.OrderDialogFragment;
import com.realmucho.prokatproject.interfaces.PaneCallBack;
import com.realmucho.prokatproject.models.ItemData;
import com.realmucho.prokatproject.adapters.ItemPagerAdapter;
import com.realmucho.prokatproject.adapters.PostsListAdapter;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;


import me.relex.circleindicator.CircleIndicator;

public class PostsActivity extends AppCompatActivity implements PaneCallBack, View.OnClickListener {

    private SlidingPaneLayout mSlidingPaneLayout;
    private RecyclerView mPostsRv;
    private PostsListAdapter mPostsAdapter;
    private MaterialRefreshLayout mRefreshLayout;
    private GridLayoutManager mGridLayoutManager;
    private ViewPager mViewPager;
    private ItemPagerAdapter mPagerAdapter;
    private ImageButton mScrollButton;
    private CircleIndicator mIndicator;
    private Button mOrder, mRelatives;
    private Toolbar mToolbar;
    private SearchView mSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts_activity);
        init();
        setupClicks();
        scrollButtonFunction();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent=new Intent(PostsActivity.this,PostsActivity.class);
                //TODO: send search query (String)
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void init(){
        mViewPager = (ViewPager) findViewById(R.id.detailed_pager);
        mIndicator = (CircleIndicator) findViewById(R.id.indicator);
        mScrollButton = (ImageButton) findViewById(R.id.scroll_up);
        mToolbar =(Toolbar)findViewById(R.id.posts_toolbar);
        mOrder = (Button) findViewById(R.id.order);
        mRelatives = (Button) findViewById(R.id.relatives);
        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refreshlayout);
        mSlidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.posts_sliding_pane);
        mPostsRv = (RecyclerView) findViewById(R.id.itemList);
        mSearchView =(SearchView)findViewById(R.id.posts_search);
        mPagerAdapter = new ItemPagerAdapter(this);
        mViewPager.setAdapter(mPagerAdapter);
        mIndicator.setViewPager(mViewPager);
        setSupportActionBar(mToolbar);
        mIndicator.animate().rotation(180);//TODO: recreate with new direction
        mPagerAdapter.registerDataSetObserver(mIndicator.getDataSetObserver());
        mSlidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mPostsRv.setLayoutManager(mGridLayoutManager);
        mPostsAdapter = new PostsListAdapter(setItemData(), this, this);
        mPostsRv.setAdapter(mPostsAdapter);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void setupClicks(){
        mOrder.setOnClickListener(this);
        mRelatives.setOnClickListener(this);
    }

    /**Initializing and organizing scrollUp buttons functions*/
    private void scrollButtonFunction() {
        mScrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridLayoutManager layoutManager = (GridLayoutManager) mPostsRv.getLayoutManager();
                layoutManager.scrollToPositionWithOffset(0, 0);
            }
        });
        mPostsRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int firstPosition = mGridLayoutManager.findFirstVisibleItemPosition();
                if (firstPosition != 0) {
                    mScrollButton.setVisibility(View.VISIBLE);
                } else {
                    mScrollButton.setVisibility(View.GONE);
                }
            }
        });
    }


    /**Setting local data for testing recyclerView*/
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
        //TODO: set duration to onSuccess
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefresh();
                    }
                }, 1000);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent reqIntent = getIntent();
        Intent intent;


        if (mSlidingPaneLayout.isOpen()) {
            mSlidingPaneLayout.closePane();
        }

        /**If activity is opened from Top or New offers' section*/
        else if (!mSlidingPaneLayout.isOpen()) {
            if (reqIntent.getIntExtra("req_top", 5) == 0) {
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            } else if (reqIntent.getIntExtra("req_new", 5) == 1) {
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else {

                super.onBackPressed();

            }
        }

    }

    @Override
    public void paneOpen(int position) {
        mSlidingPaneLayout.openPane();
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
