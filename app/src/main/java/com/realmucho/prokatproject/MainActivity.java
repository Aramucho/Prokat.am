package com.realmucho.prokatproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.Menu;
import android.view.MenuItem;

import com.realmucho.prokatproject.Fragments.AboutFragment;
import com.realmucho.prokatproject.Fragments.ConditionsFragment;
import com.realmucho.prokatproject.Fragments.FeedBackFragment;
import com.realmucho.prokatproject.Fragments.GoodsFragment;
import com.realmucho.prokatproject.Fragments.MainFragment;
import com.realmucho.prokatproject.Fragments.NewOfFragment;
import com.realmucho.prokatproject.Fragments.RealtyFragment;
import com.realmucho.prokatproject.Fragments.ServiceFragment;
import com.realmucho.prokatproject.Fragments.TopOfFragment;
import com.realmucho.prokatproject.Fragments.TransportFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SearchView search;
    private FloatingActionButton add;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        search = (SearchView) findViewById(R.id.search);
        add = (FloatingActionButton) findViewById(R.id.fab);
        fragment = (Fragment)this.getSupportFragmentManager().findFragmentById(R.id.frag);
        if (fragment instanceof MainFragment){
            add.setVisibility(View.VISIBLE);
        }
        else if(fragment instanceof TopOfFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof NewOfFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof FeedBackFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof ConditionsFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof AboutFragment){
            add.setVisibility(View.GONE);
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                Intent intent;
                switch (id){
            case R.id.fab:
                intent=new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                break;
            }
        }});


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
        int id = item.getItemId();

        switch (id) {

            case R.id.main:
                fragment = new MainFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("",false);
                if(!search.isIconified())
                {
                    search.setIconified(true);
                }
                add.setVisibility(View.VISIBLE);

                break;
            case R.id.topof:
                fragment = new TopOfFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("",false);
                add.setVisibility(View.GONE);
                if(!search.isIconified())
                {
                    search.setIconified(true);
                }
                break;
            case R.id.newof:
                fragment = new NewOfFragment();
                search.setVisibility(View.VISIBLE);
                search.setQuery("",false);
                add.setVisibility(View.GONE);
                if(!search.isIconified())
                {
                    search.setIconified(true);
                }
                break;
            case R.id.about:
                fragment = new AboutFragment();
                search.setVisibility(View.GONE);
                add.setVisibility(View.GONE);

                break;
            case R.id.conditions:
                fragment = new ConditionsFragment();
                search.setVisibility(View.GONE);
                add.setVisibility(View.GONE);
                break;
            case R.id.feedback:
                fragment = new FeedBackFragment();
                search.setVisibility(View.GONE);
                add.setVisibility(View.GONE);
                break;

        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frag, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragment = (Fragment)this.getSupportFragmentManager().findFragmentById(R.id.frag);
        if (fragment instanceof MainFragment){
            add.setVisibility(View.VISIBLE);
        }
        else if(fragment instanceof TopOfFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof NewOfFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof FeedBackFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof ConditionsFragment){
            add.setVisibility(View.GONE);
        }
        else if(fragment instanceof AboutFragment){
            add.setVisibility(View.GONE);
        }
    }
}
