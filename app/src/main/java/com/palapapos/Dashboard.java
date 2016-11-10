package com.palapapos;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

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
                myWebView.loadUrl("http://www.palapapos.co.id/about.html");
                return true;
            case R.id.privacy_policy:
                myWebView.loadUrl("http://www.palapapos.co.id/privacy.html");
                return true;
            case R.id.term_of_use:
                myWebView.loadUrl("http://www.palapapos.co.id/terms.html");
                return true;
            case R.id.info_iklan:
                myWebView.loadUrl("http://www.palapapos.co.id/info_iklan.html");
                return true;
            case R.id.redaksi:
                myWebView.loadUrl("http://www.palapapos.co.id/redaksi.html");
                return true;
            case R.id.contact_us:
                myWebView.loadUrl("http://www.palapapos.co.id/contact.html");
                return true;
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
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/2/nusantara.html");
        } else if (id == R.id.megapolitan) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/3/megapolitan.html");
        } else if (id == R.id.politik) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/4/politik.html");
        } else if (id == R.id.ekonomi) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/5/ekonomi.html");
        } else if (id == R.id.hukum) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/6/Hukum.html");
        } else if (id == R.id.komunitas) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/7/komunitas.html");
        } else if (id == R.id.budaya) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/8/budaya.html");
        } else if (id == R.id.artikel) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/9/artikel.html");
        } else if (id == R.id.olahraga) {
            myWebView.loadUrl("http://www.palapapos.co.id/kanal/10/olahraga.html");
        } else if (id == R.id.video) {
            myWebView.loadUrl("http://www.palapapos.co.id/video.html");
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
