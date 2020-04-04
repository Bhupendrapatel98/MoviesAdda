package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.movieadda.Adapter.BookmarkAdapter;
import com.example.movieadda.Adapter.MyListAdapter;
import com.example.movieadda.Adapter.SearchViewPager;
import com.example.movieadda.R;
import com.example.movieadda.utils.Type;
import com.google.android.material.tabs.TabLayout;

public class BookmarkActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        tablayout = findViewById(R.id.b_tabLayout);
        viewpage = findViewById(R.id.b_viewpage);

        Type.SimilarType mixlisttype = (Type.SimilarType) getIntent().getSerializableExtra("mixlisttype");

        viewpage.setAdapter(new BookmarkAdapter(getSupportFragmentManager(),mixlisttype));
        tablayout.setupWithViewPager(viewpage);

    }

}
