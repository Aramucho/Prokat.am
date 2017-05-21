package com.realmucho.prokatproject;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.realmucho.prokatproject.Fragments.GoodsCategoryFragment;
import com.realmucho.prokatproject.Fragments.RealtyCategoryFragment;
import com.realmucho.prokatproject.Fragments.ServiceCategoryFragment;
import com.realmucho.prokatproject.Fragments.TransportCategoryFragment;

public class CategoryActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        Intent intent=getIntent();
        int code=intent.getIntExtra("code",0);
        Fragment fragment=null;
        switch (code)
        {
            case 1:
                fragment=new GoodsCategoryFragment();
                break;
            case 2:
                fragment=new TransportCategoryFragment();
                break;
            case 3:
                fragment=new ServiceCategoryFragment();
                break;
            case 4:
                fragment=new RealtyCategoryFragment();
                break;

        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.category_activity, fragment).commit();

    }
}
