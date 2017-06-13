package com.realmucho.prokatproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;


import com.realmucho.prokatproject.Fragments.DrawerFragments.AboutFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.ConditionsFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.FeedBackFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.MainFragment;

import com.realmucho.prokatproject.Fragments.DrawerFragments.NewOfFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.TopOfFragment;
import com.realmucho.prokatproject.Interfaces.DisableOnClick;
import com.realmucho.prokatproject.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SearchView search;
    private Fragment mainFragment;
    private RelativeLayout mainfraglayout;
    private DisableOnClick disableOnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainFragment = new MainFragment();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.root, mainFragment).commit();
        search = (SearchView) findViewById(R.id.search);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        Intent intent;
        int reqcode;

        int id = item.getItemId();


        switch (id) {

            case R.id.main:
                fragment = new MainFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("", false);
                if (!search.isIconified()) {
                    search.setIconified(true);
                }


                break;
            case R.id.topof:
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int reqcod = 0;
                        Intent intent = new Intent(MainActivity.this, PostsActivity.class);
                        intent.putExtra("req_top", reqcod);
                        startActivity(intent);
                    }
                }, 3000);


                fragment = new MainFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("", false);

                if (!search.isIconified()) {
                    search.setIconified(true);
                }

                disableOnClick.disableclick();


                break;
            case R.id.newof:
                reqcode = 1;
                intent = new Intent(MainActivity.this, PostsActivity.class);
                intent.putExtra("req_new", reqcode);
                startActivity(intent);
                fragment = new MainFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("", false);
                if (!search.isIconified()) {
                    search.setIconified(true);
                }
                mainfraglayout.setClickable(false);
                disableOnClick.disableclick();
                break;
            case R.id.about:
                intent = new Intent(MainActivity.this, PostsActivity.class);
                startActivity(intent);
                fragment = new AboutFragment();
                search.setVisibility(View.GONE);


                break;
            case R.id.conditions:
                fragment = new ConditionsFragment();
                search.setVisibility(View.GONE);

                break;
            case R.id.feedback:
                fragment = new FeedBackFragment();
                search.setVisibility(View.GONE);

                break;
            case R.id.langch:


                break;


        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.root, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    void setDisableClickListner(DisableOnClick disableClickListner) {
        this.disableOnClick = disableClickListner;
    }


}
