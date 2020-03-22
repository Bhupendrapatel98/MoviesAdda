package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.Fragments.CastFragment;
import com.example.movieadda.utils.Type;

public class CelebritiesActivity extends AppCompatActivity {

    FrameLayout celebrity_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrities);

        celebrity_frame = findViewById(R.id.celebrity_frame);

    }

    protected void setFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.celebrity_frame, fragment);
        t.commit();
    }
}
