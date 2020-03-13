package com.example.movieadda.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieadda.R;
import com.example.movieadda.ui.Fragments.HomeFragment;
import com.example.movieadda.ui.Fragments.ListFragMent;
import com.example.movieadda.ui.Fragments.MenuFragment;
import com.example.movieadda.ui.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    BottomNavigationView main_nav;
    TextView internet;
    TextView refreshbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.frame);
        main_nav = findViewById(R.id.main_nav);
        internet = findViewById(R.id.internet);
        refreshbtn = findViewById(R.id.refreshbtn);


       if(isNetworkConnected()==false){

           internet.setVisibility(View.VISIBLE);
           refreshbtn.setVisibility(View.VISIBLE);

           refreshbtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (isNetworkConnected()==false){
                       Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_LONG).show();
                   }
                   else {
                   startActivity(new Intent(MainActivity.this,MainActivity.class));
                   finish();
                   }
               }
           });

       }
       else {

           internet.setVisibility(View.GONE);

           replace(new HomeFragment());

           main_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                   switch (item.getItemId()) {

                       case R.id.home:
                           Log.i("ckjbnkbg", "onNavigationItemReselected: " + item.getItemId());
                           replace(new HomeFragment());
                           return true;

                       case R.id.Search:
                           replace(new SearchFragment());
                           return true;


                       case R.id.MyLists:
                           replace(new ListFragMent());
                           return true;


                       case R.id.Menu:
                           replace(new MenuFragment());
                           return true;
                   }
                   return false;
               }
           });
       }

       }


    void replace(Fragment fragment){
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
