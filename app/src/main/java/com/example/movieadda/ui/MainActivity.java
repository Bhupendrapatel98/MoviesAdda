package com.example.movieadda.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.Fragments.HomeFragment;
import com.example.movieadda.ui.Fragments.ListFragMent;
import com.example.movieadda.ui.Fragments.MenuFragment;
import com.example.movieadda.ui.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    BottomNavigationView main_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.frame);
        main_nav = findViewById(R.id.main_nav);

        replace(new HomeFragment());

        main_nav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home :
                        replace(new HomeFragment());
                        break;

                    case R.id.Search :
                        replace(new SearchFragment());
                        break;


                    case R.id.MyLists :
                        replace(new ListFragMent());
                        break;


                    case R.id.Menu :
                        replace(new MenuFragment());
                        break;
                }
            }
        });


    }


    void replace(Fragment fragment){
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }
}
