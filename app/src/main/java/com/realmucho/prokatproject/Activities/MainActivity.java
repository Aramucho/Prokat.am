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


import com.realmucho.prokatproject.Fragments.DrawerFragments.AboutFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.ConditionsFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.FeedBackFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.MainFragment;


import com.realmucho.prokatproject.Interfaces.DisableOnClick;
import com.realmucho.prokatproject.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SearchView search;
    private Fragment mainFragment;


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
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);

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

                reqcode = 0;
                intent = new Intent(MainActivity.this, PostsActivity.class);
                intent.putExtra("req_top", reqcode);
                startActivity(intent);
                fragment = new MainFragment();

                search.setVisibility(View.VISIBLE);
                search.setQuery("", false);

                if (!search.isIconified()) {
                    search.setIconified(true);
                }


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

                break;
            case R.id.about:

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


        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.root, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
