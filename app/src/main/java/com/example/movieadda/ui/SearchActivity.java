package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieadda.Adapter.SearchViewPager;
import com.example.movieadda.Adapter.ViewPagerAdapter;
import com.example.movieadda.R;
import com.example.movieadda.utils.Type;
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

        //show keyboard autometic
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        search();
           }

    public void search(){

        search_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //hide keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);

                Log.i("mjcbdjjddfdkff", "onClick: "+s_edit.getText().toString());

                if (s_edit.getText().toString().isEmpty()){

                }
                else {
                    s_viewpage.setAdapter(new SearchViewPager(getSupportFragmentManager(), s_edit.getText().toString()));
                    s_viewpage.setOffscreenPageLimit(0);
                    s_tabLayout.setupWithViewPager(s_viewpage);
                }
            }
        });
    }
}
