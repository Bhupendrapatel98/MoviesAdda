package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.movieadda.Adapter.MyListAdapter;
import com.example.movieadda.R;
import com.example.movieadda.ui.SearchActivity;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragMent extends Fragment {

    TabLayout tablayoumtv;
    ViewPager viewPagermtv;
    ImageView msearch;
    View view;
    private FragmentManager supportFragmentManager;


    public ListFragMent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_frag_ment, container, false);

        tablayoumtv=view.findViewById(R.id.tablayoutmtv);
        viewPagermtv=view.findViewById(R.id.viewpagermtv);
        msearch = view.findViewById(R.id.msearchicon);

        viewPagermtv.setAdapter(new MyListAdapter(getFragmentManager()));
        tablayoumtv.setupWithViewPager(viewPagermtv);

        msearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
