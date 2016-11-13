package com.palapapos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
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
import com.palapapos.Video.Video;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);

        myWebView.requestFocusFromTouch();
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.loadUrl("http://www.palapapos.co.id/");

        myWebView.setWebViewClient(new WebViewClient());

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            myWebView.loadUrl("http://www.palapapos.co.id/");
        } else if (id == R.id.berita_terkini) {
            Intent i = new Intent(Dashboard.this, Terkini.class);
            startActivity(i);
        } else if (id == R.id.berita_terpopuler) {
            Intent i = new Intent(Dashboard.this, Terpopuler.class);
            startActivity(i);
        } else if (id == R.id.nasional) {
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
}
