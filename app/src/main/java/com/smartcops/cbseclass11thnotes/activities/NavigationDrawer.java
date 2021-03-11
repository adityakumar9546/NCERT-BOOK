package com.smartcops.cbseclass11thnotes.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.BuildConfig;
import com.google.android.material.navigation.NavigationView;
import com.smartcops.cbseclass11thnotes.R;
import com.smartcops.cbseclass11thnotes.pojo.Topic;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Topic> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("CBSE CLASS 11th NOTES");
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        recyclerView = findViewById(R.id.recyclerview);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(NavigationDrawer.this,drawerLayout,toolbar,R.string.open_header,R.string.close_header);
        toggle.getDrawerArrowDrawable().setColor(Color.parseColor("#ffffff"));
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        list = new ArrayList<>();
//        list.add(new Topic(R.drawable.))

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        switch (id){

            case R.id.feedback_id:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","copsmartapp@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "CBSE CLASS 11th NOTES");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                break;

            case R.id.rateus_id:
                rateUs(NavigationDrawer.this);
                break;

            case R.id.shareapp_id:
                share(NavigationDrawer.this);
                break;

            case R.id.privacypolicy_id:
                Uri url = Uri.parse("https://sites.google.com/view/ncertclass12thchemistrybooks");
                Intent myintent = new Intent(Intent.ACTION_VIEW, url);
                try {
                    startActivity(myintent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(this,"Privacy Policy",Toast.LENGTH_SHORT).show();
                }
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }


    public static void share(Context context) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "NCERT BOOK & SOLUTIONS");
            String shareMessage = "Check out this amazing app";
            //shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            context.startActivity(Intent.createChooser(shareIntent, "Choose One"));
        } catch (Exception e) {
            //e.toString();
        }
    }

    public static void rateUs(Context context) {
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.share:
                share(NavigationDrawer.this);
                break;

            case R.id.rate:
                rateUs(NavigationDrawer.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}