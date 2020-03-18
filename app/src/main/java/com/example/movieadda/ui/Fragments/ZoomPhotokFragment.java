package com.example.movieadda.ui.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.movieadda.Network.Constants;
import com.example.movieadda.R;
import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZoomPhotokFragment extends Fragment {

    ImageView photos;
    String filepath;

    public ZoomPhotokFragment(String filePath) {
        // Required empty public constructor
        this.filepath=filePath;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zoom_photok, container, false);

        Log.i("mjdckdxfkdf", "onCreateView: "+filepath);
        photos = view.findViewById(R.id.photos);
        Picasso.get().load(Constants.Image_URL+filepath).into(photos);
        return view;
    }

}
