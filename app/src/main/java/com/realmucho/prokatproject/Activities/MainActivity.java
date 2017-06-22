package com.realmucho.prokatproject.Activities;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
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
import com.realmucho.prokatproject.Fragments.DrawerFragments.LandMainFragment;
import com.realmucho.prokatproject.Fragments.DrawerFragments.MainFragment;
import com.realmucho.prokatproject.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SearchView search;
    private Fragment mainFragment, landmainFragment;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private ActionBarDrawerToggle toggle;
    private Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        fragmentManager = getSupportFragmentManager();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentManager.beginTransaction().add(R.id.root, mainFragment, "Main").commit();

        } else {
            fragmentManager.beginTransaction().add(R.id.root, landmainFragment, "Land").commit();

        }
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, PostsActivity.class);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mainFragment.isAdded() || landmainFragment.isAdded() || fragment instanceof MainFragment || fragment instanceof LandMainFragment) {

            if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                fragmentManager.beginTransaction().replace(R.id.root, mainFragment).commit();
            } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                fragmentManager.beginTransaction().replace(R.id.root, landmainFragment).commit();
            }

        }

    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        search = (SearchView) findViewById(R.id.search);
        mainFragment = new MainFragment();
        landmainFragment = new LandMainFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.arm:
                return true;
            case R.id.rus:
                return true;
            case R.id.eng:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        Intent intent;
        int reqcode;

        int id = item.getItemId();


        switch (id) {

            case R.id.main:
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    fragmentManager.beginTransaction().remove(fragment);
                    fragment = new MainFragment();

                } else {
                    fragmentManager.beginTransaction().remove(fragment);
                    fragment = new LandMainFragment();
                }
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

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

                    fragment = new MainFragment();

                } else {
                    fragment = new LandMainFragment();
                }


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
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    fragment = new MainFragment();

                } else {
                    fragment = new LandMainFragment();
                }

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

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.root, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}