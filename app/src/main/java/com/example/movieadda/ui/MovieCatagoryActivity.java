package com.example.movieadda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.Fragments.SimilarFragment;
import com.example.movieadda.utils.Type;

public class MovieCatagoryActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_catagory);

        frameLayout=findViewById(R.id.framelayout);

        String id=getIntent().getStringExtra("id");
        Log.i("ddgg", "onCreate: "+id);

        Type.SimilarType mixlisttype = (Type.SimilarType) getIntent().getSerializableExtra("mixlisttype");
        Log.i("sfsfsf", "onCreate: "+mixlisttype);
        Type.MovieType type = (Type.MovieType) getIntent().getSerializableExtra("type");

        setFragment(new SimilarFragment(id,mixlisttype,type));
    }
    protected void setFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.framelayout, fragment);
        t.commit();
    }
}
