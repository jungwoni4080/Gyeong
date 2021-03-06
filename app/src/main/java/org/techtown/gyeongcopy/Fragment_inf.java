package org.techtown.gyeongcopy;


import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        /*ComponentName compName = new ComponentName("org.techtown.practiveta","org.techtown.practiveta.MainActivity");
        Intent intent23 = new Intent(Intent.ACTION_MAIN);
        intent23.addCategory(Intent.CATEGORY_LAUNCHER);
        intent23.setComponent(compName);
        startActivity(intent23); */
        //디미고 내신 계산기 앱으로 이동시킴
        final Intent intent = getContext().getPackageManager().getLaunchIntentForPackage("org.techtown.practiveta");
        Button dmgbtm = (Button) view.findViewById(R.id.button3);
        dmgbtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment_inf.this.startActivity(intent);
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=org.techtown.practiveta"));
                startActivity(intent2);
            }
        });
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
