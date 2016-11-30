package com.palapapos.Megapolitan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.palapapos.AboutUs;
import com.palapapos.ContactUs;
import com.palapapos.InfoIklan;
import com.palapapos.Komunitas.Komunitas;
import com.palapapos.Nasional.Nasional;
import com.palapapos.Nasional.NasionalTerkini;
import com.palapapos.Nasional.NasionalTerpopuler;
import com.palapapos.Nusantara.Nusantara;
import com.palapapos.PrivacyPolicy;
import com.palapapos.R;
import com.palapapos.Redaksi;
import com.palapapos.TermOfUse;

import java.util.ArrayList;
import java.util.List;

public class Megapolitan extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_megapolitan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        Megapolitan.ViewPagerAdapter adapter = new Megapolitan.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MegapolitanHome(), "Mogapolitan");
        adapter.addFragment(new MegapolitanTerkini(), "Berita Terkini");
        adapter.addFragment(new MegapolitanTerpopuler(), "Berita Populer");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.home:
                finish();
            case R.id.about_us:
                Intent about_us = new Intent(Megapolitan.this, AboutUs.class);
                startActivity(about_us);
                return true;
            case R.id.privacy_policy:
                Intent privacy_policy = new Intent(Megapolitan.this, PrivacyPolicy.class);
                startActivity(privacy_policy);
                return true;
            case R.id.term_of_use:
                Intent term_of_use = new Intent(Megapolitan.this, TermOfUse.class);
                startActivity(term_of_use);
                return true;
            case R.id.info_iklan:
                Intent info_iklan = new Intent(Megapolitan.this, InfoIklan.class);
                startActivity(info_iklan);
                return true;
            case R.id.redaksi:
                Intent redaksi = new Intent(Megapolitan.this, Redaksi.class);
                startActivity(redaksi);
                return true;
            case R.id.contact_us:
                Intent contact_us = new Intent(Megapolitan.this, ContactUs.class);
                startActivity(contact_us);
                return true;
            case R.id.exit:
                finish();
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
