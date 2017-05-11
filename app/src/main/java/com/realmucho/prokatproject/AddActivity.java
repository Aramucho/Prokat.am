package com.realmucho.prokatproject;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.realmucho.prokatproject.Fragments.GoodsFragment;
import com.realmucho.prokatproject.Fragments.RealtyFragment;
import com.realmucho.prokatproject.Fragments.ServiceFragment;
import com.realmucho.prokatproject.Fragments.TransportFragment;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        viewPager = (ViewPager) findViewById(R.id.add_view_pager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.goods_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.transport_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.realty_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.service_icon);


    }

    private void setupViewPager(ViewPager viewPager) {
        AddPagerAdapter adapter = new AddPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GoodsFragment(), getString(R.string.goods));
        adapter.addFragment(new TransportFragment(), getString(R.string.transport));
        adapter.addFragment(new RealtyFragment(), getString(R.string.realty));
        adapter.addFragment(new ServiceFragment(), getString(R.string.service));
        viewPager.setAdapter(adapter);
    }

    class AddPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public AddPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


    }
}
