package com.example.movieadda.ui.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.movieadda.R;
import com.example.movieadda.ui.AppInfoActivity;
import com.example.movieadda.ui.BookmarkActivity;
import com.example.movieadda.ui.ProfileActivity;
import com.example.movieadda.ui.SearchActivity;
import com.example.movieadda.utils.Type;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

LinearLayout appinfo,share,rate,bookmark;
ImageView msearchicon;

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
        msearchicon = view.findViewById(R.id.msearchicon);

        msearchicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), BookmarkActivity.class);
                intent.putExtra("mixlisttype", Type.SimilarType.BOOKMARK);
                startActivity(intent);
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=PackageName")));
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });

        appinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AppInfoActivity.class));
            }
        });

        return view;
    }


}
