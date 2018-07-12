package com.example.admin.navchapter;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.admin.navchapter.model.ChapterTextFragment;
import com.example.admin.navchapter.model.abstractFragment;


public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final static ChapterTextFragment chapterTextFragment = new ChapterTextFragment ();
    final static ChapterFrame  chapterFrame = new ChapterFrame();
    final static DefaultFragment defaultFragment = new DefaultFragment();
    public static android.support.v4.app.FragmentTransaction transaction;
    public static android.support.v4.app.FragmentManager fragmentManager;
    public static int currentFragmentId;
    static final String TAG ="PRESS";
    public static TextView chapterText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //transaction = getFragmentManager().beginTransaction();
        currentFragmentId = R.id.default_fragment;


        chapterText = findViewById(R.id.chapterText);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        currentFragmentId = R.id.default_fragment;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        Log.d(TAG, ""+currentFragmentId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int i = item.getItemId();

        Log.d(TAG, "chapters " +currentFragmentId);

        switch (i){
            case R.id.nav_chapters:

                if(currentFragmentId!=R.id.rv) {

                    replaceFragment(chapterFrame, getSupportFragmentManager());
//                    transaction = getFragmentManager().beginTransaction();
//                    transaction.replace(currentFragmentId, chapterFrame);
//                    transaction.addToBackStack("chapter_fragment");
//                    transaction.commit();


                    currentFragmentId = R.id.rv;
                    }



                break;

            case R.id.nav_notions:
                break;

            case R.id.nav_share:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public static <T extends abstractFragment<Fragment>> void replaceFragment (abstractFragment <Fragment> newFragment, android.support.v4.app.FragmentManager fragmentManager){

        transaction = fragmentManager.beginTransaction();
        transaction.replace(currentFragmentId,  newFragment);
        transaction.addToBackStack("chapter_fragment");
        transaction.commit();
    }

}
