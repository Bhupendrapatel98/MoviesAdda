package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.AppInfoActivity;
import com.example.movieadda.ui.ProfileActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

LinearLayout appinfo,share,rate,bookmark;

    public MenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        bookmark = view.findViewById(R.id.bookmark);
        rate = view.findViewById(R.id.rate);
        share = view.findViewById(R.id.share);
        appinfo = view.findViewById(R.id.appinfo);

        appinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AppInfoActivity.class));
            }
        });

        return view;
    }

}
