package com.realmucho.prokatproject.Activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.realmucho.prokatproject.Fragments.AddFragments.GoodsFragment;
import com.realmucho.prokatproject.Fragments.AddFragments.RealtyFragment;
import com.realmucho.prokatproject.Fragments.AddFragments.ServiceFragment;
import com.realmucho.prokatproject.Fragments.AddFragments.TransportFragment;
import com.realmucho.prokatproject.R;

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
        tabLayout.getTabAt(0).setIcon(R.drawable.goods_icon_change);
        tabLayout.getTabAt(1).setIcon(R.drawable.transport_icon_change);
        tabLayout.getTabAt(2).setIcon(R.drawable.realty_icon_change);
        tabLayout.getTabAt(3).setIcon(R.drawable.service_icon_change);


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

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode) {
//
//            case 888: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(intent, 1);
//
//                } else {
//                    Toast.makeText(this, "I have no permission for opening your camera(((", Toast.LENGTH_SHORT).show();
//                }
//
//                return;
//            }
//        }
//    }


}
