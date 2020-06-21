package org.techtown.gyeongcopy;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.techtown.gyeongcopy.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_inf extends Fragment {


    public Fragment_inf() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_inf, container, false);
        /*ImageView iv = (ImageView)view.findViewById(R.id.imageView6);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goe.go.kr/")));
            }
        });*/
        return view;
    }

}
