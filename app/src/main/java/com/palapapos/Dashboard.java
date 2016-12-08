package com.palapapos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.palapapos.Artikel.Artikel;
import com.palapapos.Budaya.Budaya;
import com.palapapos.Ekonomi.Ekonomi;
import com.palapapos.Hukum.Hukum;
import com.palapapos.Komunitas.Komunitas;
import com.palapapos.Megapolitan.Megapolitan;
import com.palapapos.Nasional.Nasional;
import com.palapapos.Nusantara.Nusantara;
import com.palapapos.Olahraga.Olahraga;
import com.palapapos.Politik.Politik;
import com.palapapos.Politik.PolitikTerkini;
import com.palapapos.Politik.PolitikTerpopuler;
import com.palapapos.Video.Video;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myWebView = (WebView) findViewById(R.id.webView);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        drawer.closeDrawers();
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

//        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
//        myFab.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                myWebView.setWebViewClient(new WebViewClient() {
//                    public void onPageFinished(WebView view, String url) {
//                        view.scrollTo(0,0);
//                    }
//                });
//            }
//        });
    }

    private void setupViewPager(ViewPager viewPager) {
        Dashboard.ViewPagerAdapter adapter = new Dashboard.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home(), "Home");
        adapter.addFragment(new Terkini(), "Berita Terkini");
        adapter.addFragment(new Terpopuler(), "Berita Populer");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView.canGoBack()) {
                        myWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.about_us:
                Intent about_us = new Intent(Dashboard.this, AboutUs.class);
                startActivity(about_us);
                return true;
            case R.id.privacy_policy:
                Intent privacy_policy = new Intent(Dashboard.this, PrivacyPolicy.class);
                startActivity(privacy_policy);
                return true;
            case R.id.term_of_use:
                Intent term_of_use = new Intent(Dashboard.this, TermOfUse.class);
                startActivity(term_of_use);
                return true;
            case R.id.info_iklan:
                Intent info_iklan = new Intent(Dashboard.this, InfoIklan.class);
                startActivity(info_iklan);
                return true;
            case R.id.redaksi:
                Intent redaksi = new Intent(Dashboard.this, Redaksi.class);
                startActivity(redaksi);
                return true;
            case R.id.contact_us:
                Intent contact_us = new Intent(Dashboard.this, ContactUs.class);
                startActivity(contact_us);
                return true;
            case R.id.exit:
                finish();
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
        }  else if (id == R.id.nasional) {
            Intent i = new Intent(Dashboard.this, Nasional.class);
            startActivity(i);
        } else if (id == R.id.nusantara) {
            Intent i = new Intent(Dashboard.this, Nusantara.class);
            startActivity(i);
        } else if (id == R.id.megapolitan) {
            Intent i = new Intent(Dashboard.this, Megapolitan.class);
            startActivity(i);
        } else if (id == R.id.politik) {
            Intent i = new Intent(Dashboard.this, Politik.class);
            startActivity(i);
        } else if (id == R.id.ekonomi) {
            Intent i = new Intent(Dashboard.this, Ekonomi.class);
            startActivity(i);
        } else if (id == R.id.hukum) {
            Intent i = new Intent(Dashboard.this, Hukum.class);
            startActivity(i);
        } else if (id == R.id.komunitas) {
            Intent i = new Intent(Dashboard.this, Komunitas.class);
            startActivity(i);
        } else if (id == R.id.budaya) {
            Intent i = new Intent(Dashboard.this, Budaya.class);
            startActivity(i);
        } else if (id == R.id.artikel) {
            Intent i = new Intent(Dashboard.this, Artikel.class);
            startActivity(i);
        } else if (id == R.id.olahraga) {
            Intent i = new Intent(Dashboard.this, Olahraga.class);
            startActivity(i);
        } else if (id == R.id.video) {
            Intent i = new Intent(Dashboard.this, Video.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
