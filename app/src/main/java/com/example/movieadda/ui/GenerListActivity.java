package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.Fragments.HomeFragment;
import com.example.movieadda.ui.Fragments.SimilarFragment;
import com.example.movieadda.utils.Type;

public class GenerListActivity extends AppCompatActivity {

    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gener_list);

        frame = findViewById(R.id.frame);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        replace(new SimilarFragment(id, Type.SimilarType.GENER,Type.MovTv.MOVIE));
    }

    void replace(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }
}
