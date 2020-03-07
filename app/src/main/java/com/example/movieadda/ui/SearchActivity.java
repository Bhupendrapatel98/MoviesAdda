package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.movieadda.Adapter.SearchViewPager;
import com.example.movieadda.R;
import com.google.android.material.tabs.TabLayout;

public class SearchActivity extends AppCompatActivity {

    TabLayout s_tabLayout;
    ViewPager s_viewpage;
    ImageView search_icon;
    EditText s_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        s_tabLayout = findViewById(R.id.s_tabLayout);
        s_viewpage = findViewById(R.id.s_viewpage);
        search_icon = findViewById(R.id.search_icon);
        s_edit = findViewById(R.id.s_edit);

        search_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String stext = s_edit.getText().toString();
             s_viewpage.setAdapter(new SearchViewPager(getSupportFragmentManager(),stext));
                s_viewpage.setOffscreenPageLimit(0);
                s_tabLayout.setupWithViewPager(s_viewpage);
            }
        });
    }
}
