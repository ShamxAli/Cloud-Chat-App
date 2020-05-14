package com.startup.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.startup.chatapp.adapters.ViewPagerAdapter;
import com.startup.chatapp.fragments.AccountFragment;
import com.startup.chatapp.fragments.ChatFragment;
import com.startup.chatapp.fragments.ContactsFragment;

public class HomeActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager());

        // Added later...
        viewPagerAdapter.addFragment(new ChatFragment(), "Chats");
        viewPagerAdapter.addFragment(new ContactsFragment(), "Contacts");
        viewPagerAdapter.addFragment(new AccountFragment(), "Account");


        viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);

        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(viewPagerAdapter);
        tabs.setupWithViewPager(viewPager);


    }


    public void setCurrentItem(int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }
}
