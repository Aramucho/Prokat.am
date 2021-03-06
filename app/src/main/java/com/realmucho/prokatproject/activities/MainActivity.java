package com.realmucho.prokatproject.activities;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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


import com.realmucho.prokatproject.R;
import com.realmucho.prokatproject.fragments.drawer_fragments.AboutFragment;
import com.realmucho.prokatproject.fragments.drawer_fragments.ConditionsFragment;
import com.realmucho.prokatproject.fragments.drawer_fragments.FeedBackFragment;
import com.realmucho.prokatproject.fragments.drawer_fragments.LandMainFragment;
import com.realmucho.prokatproject.fragments.drawer_fragments.MainFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SearchView mSearch;
    private Fragment mMainFragment, mLandMainFragment;
    private Toolbar mToolbar;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private ActionBarDrawerToggle mToggle;
    private Fragment mPageFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);
        init();
        drawerInit();
        mFragmentManager = getSupportFragmentManager();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mFragmentManager.beginTransaction().add(R.id.root, mMainFragment, "Main").commit();

        } else {
            mFragmentManager.beginTransaction().add(R.id.root, mLandMainFragment, "Land").commit();

        }

        mSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, PostsActivity.class);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mMainFragment.isAdded() || mLandMainFragment.isAdded() || mPageFragment instanceof MainFragment || mPageFragment instanceof LandMainFragment) {

            if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                mFragmentManager.beginTransaction().replace(R.id.root, mMainFragment).commit();
            } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                mFragmentManager.beginTransaction().replace(R.id.root, mLandMainFragment).commit();
            }

        }

    }

    private void init() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mSearch = (SearchView) findViewById(R.id.search);
        mMainFragment = new MainFragment();
        mLandMainFragment = new LandMainFragment();
    }

    private void drawerInit(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(mToggle);
        mToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /**Changing language*/
        switch (item.getItemId()) {
            case R.id.arm:
                setLocale("hy");
                recreate();
                return true;
            case R.id.rus:
                setLocale("ru");
                recreate();
                return true;
            case R.id.eng:
                setLocale("en");
                recreate();
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
        }
        /**Exiting from app only from mainFragment*/
        else {
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
        int reqCode;
        int id = item.getItemId();


        switch (id) {

            case R.id.main:
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    mFragmentManager.beginTransaction().remove(mPageFragment);
                    mPageFragment = new MainFragment();

                } else {
                    mFragmentManager.beginTransaction().remove(mPageFragment);
                    mPageFragment = new LandMainFragment();
                }
                /**do not need to be visible in some fragments*/
                mSearch.setVisibility(View.VISIBLE);
                mSearch.setQuery("", false);
                /**need to be closed when come back to that fragment*/
                if (!mSearch.isIconified()) {
                    mSearch.setIconified(true);
                }


                break;
            case R.id.topof:

                reqCode = 0;
                intent = new Intent(MainActivity.this, PostsActivity.class);
                intent.putExtra("req_top", reqCode);
                startActivity(intent);
                //TODO: set clickable false for pizza
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    mPageFragment = new MainFragment();
                } else {
                    mPageFragment = new LandMainFragment();
                }

                mSearch.setVisibility(View.VISIBLE);
                mSearch.setQuery("", false);

                if (!mSearch.isIconified()) {
                    mSearch.setIconified(true);
                }


                break;
            case R.id.newof:
                reqCode = 1;
                intent = new Intent(MainActivity.this, PostsActivity.class);
                intent.putExtra("req_new", reqCode);
                startActivity(intent);
                //TODO: set clickable false for pizza
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    mPageFragment = new MainFragment();
                } else {
                    mPageFragment = new LandMainFragment();
                }

                mSearch.setVisibility(View.VISIBLE);
                mSearch.setQuery("", false);
                if (!mSearch.isIconified()) {
                    mSearch.setIconified(true);
                }

                break;
            case R.id.about:
                mPageFragment = new AboutFragment();
                mSearch.setVisibility(View.GONE);


                break;
            case R.id.conditions:
                mPageFragment = new ConditionsFragment();
                mSearch.setVisibility(View.GONE);

                break;
            case R.id.feedback: {
                mPageFragment = new FeedBackFragment();
                mSearch.setVisibility(View.GONE);
                break;
            }


        }


        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.root, mPageFragment).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**Changes language of application*/
    private void setLocale(String lang) {
        if (lang.equalsIgnoreCase("")) {
            return;
        }
        Locale myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    /**Saves language changes*/
    public void saveLocale(String lang) {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }

    /**Get saved language and set it*/
    public void loadLocale() {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs",
                Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        setLocale(language);
    }


}