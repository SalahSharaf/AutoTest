package com.example.android.androidtutorial2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;
    ActionBarDrawerToggle actionToggle;
    public static ArrayList<User> users;
    public static User user;
    public static boolean isAuthenticated;
    //recycler view
    RecyclerView rcView;
    ArrayList<Test> tests;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<>();
        tests=new ArrayList<>();
        users.add(new User("hasan", "2114008", "hasan.amse@gmail.com", false));
        users.add(new User("salah", "2114008", "salah.amse@gmail.com", true));
        rcView=findViewById(R.id.test_RecycleView);
        adapter=new RecyclerViewAdapter(tests);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(mLayoutManager);
        rcView.setItemAnimator(new DefaultItemAnimator());
        rcView.setAdapter(adapter);
        preparetestData();
        ///////////////////
    }

    private void preparetestData() {
        Test test = new Test("Mad Max: Fury Road", "Action & Adventure", "2srtjhath015",new Date(2002,11,22),100,50);
        tests.add(test);

        Test test1 = new Test("Mad Max: Fury Road", "Action & Adventure", "201haerhaeh5",new Date(2002,11,22),100,50);
        tests.add(test1);

        Test test2 = new Test("Mad Max: Fury Road", "Action & Adventure", "201aeWQWDWEF5",new Date(2002,11,22),100,50);
        tests.add(test2);

        Test test3 = new Test("Mad Max: Fury Road", "Action & Adventure", "20AWEGweg15", new Date(2002,11,22),100,50);
        tests.add(test3);

        Test test4 = new Test("Mad Max: Fury Road", "Action & Adventure", "20wegeg15",new Date(2002,11,22),100,50);
        tests.add(test4);

        Test test5 = new Test("Mad Max: Fury Road", "Action & Adventure", "20WETERTRY15",new Date(2002,11,22),100,50);
        tests.add(test5);

        Test test6 = new Test("Mad Max: Fury Road", "Action & Adventure", "201SHFMGYJTY5",new Date(2002,11,22),100,50);
        tests.add(test6);

        Test test7 = new Test("Mad Max: Fury Road", "Action & Adventure", "2erthrheh015",new Date(2002,11,22),100,50);
        tests.add(test7);

        Test test8 = new Test("Mad Max: Fury Road", "Action & Adventure", "2eerqwrr015",new Date(2002,11,22),100,50);
        tests.add(test8);

        Test test9 = new Test("Mad Max: Fury Road", "Action & Adventure", "20ergerge15",new Date(2002,11,22),100,50);
        tests.add(test9);

        Test test10 = new Test("Mad Max: Fury Road", "Action & Adventure", "2ergrge015",new Date(2002,11,22),100,50);
        tests.add(test10);

        Test test11 = new Test("Mad Max: Fury Road", "Action & Adventure", "20qwdwsd15",new Date(2002,11,22),100,50);
        tests.add(test11);

        Test test12 = new Test("Mad Max: Fury Road", "Action & Adventure", "rgeg",new Date(2002,11,22),100,50);
        tests.add(test12);

        Test test13 = new Test("Mad Max: Fury Road", "Action & Adventure", "201dgerhw5",new Date(2002,11,22),100,50);
        tests.add(test13);

        Test test14 = new Test("Mad Max: Fury Road", "Action & Adventure", "eergrg",new Date(2002,11,22),100,50);
        tests.add(test14);

        Test test15 = new Test("Mad Max: Fury Road", "Action & Adventure", "erger",new Date(2002,11,22),100,50);
        tests.add(test15);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        TextView textView = new TextView(this);
        drawerlayout = findViewById(R.id.drawer);
        Button btn = findViewById(R.id.logOutButton);
        RelativeLayout rl = findViewById(R.id.relativeLayout);
        Button btn1 = findViewById(R.id.loginButton);
        Button btn2 = findViewById(R.id.signupButton);
        NavigationView navView = findViewById(R.id.nav_view);
        View inflatedView = navView.inflateHeaderView(R.layout.navigation_header);
        ImageView userImage = inflatedView.findViewById(R.id.user_image);
        TextView textViews = inflatedView.findViewById(R.id.user_name);
        ImageButton btnAddNewTest=findViewById(R.id.addNewTestButton);
        ImageButton btnGOHome=findViewById(R.id.goHomeButton);
        if (isAuthenticated) {
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
            if(user.getAdmin()) {
                btnAddNewTest.setVisibility(View.VISIBLE);
            }else {
                btnGOHome.setVisibility(View.VISIBLE);
            }
            textView.setText("Welcome  " + user.getName());
            textView.setTextSize(16f);
            actionToggle = new ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            textView.setPadding(10, 10, 10, 10);
            rl.addView(textView);
            btn.setVisibility(View.VISIBLE);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), login.class);
                    startActivity(intent);
                }
            });
            ///////////////////////////////////////////////////////////////////////////////////////
            actionToggle.setDrawerIndicatorEnabled(true);
            drawerlayout.addDrawerListener(actionToggle);
            actionToggle.syncState();
            userImage.setImageBitmap(user.getPhoto());
            textViews.setText(user.getName());
            //the line for showing up the toggle in the ActionBar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.item_home) {

                    } else if (id == R.id.item_account) {

                    } else if (id == R.id.item_preferences) {

                    }
                    return true;
                }
            });
            isAuthenticated = false;
        } else if (isAuthenticated == false) {
            btn1 = findViewById(R.id.loginButton);
            btn2 = findViewById(R.id.signupButton);
            btn = findViewById(R.id.logOutButton);
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);
            drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            textView.setText("");
            btnAddNewTest.setVisibility(View.INVISIBLE);
            btnGOHome.setVisibility(View.INVISIBLE);
        }
        super.onStart();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to qui").setTitle("Quit").setCancelable(true).setIcon(R.drawable.ic_priority_high_black_24dp)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog shower=builder.create();
        shower.show();
    }
    public void addNewTest(View view){

    }

    public void goHome(View view){

    }
}
