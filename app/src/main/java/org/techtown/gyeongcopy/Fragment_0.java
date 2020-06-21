package org.techtown.gyeongcopy;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.techtown.gyeongcopy.R;
import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_0 extends Fragment {

    TextView one1, one2, one3, one4, one5,one6,one7,one8,one9;
    double chaeyae;
    double twoone,twotwo,throne,thrtwo, sum,sangchul,sangbong,artpe,artpe1,artpe2,artpe3,artpe4,sanghak;
    public Fragment_0() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fragment_0,null);
        one1=(TextView)view.findViewById(R.id.score);
        one2=(TextView)view.findViewById(R.id.score2);
        one3=(TextView)view.findViewById(R.id.score3);
        one4=(TextView)view.findViewById(R.id.score4);
        one5=(TextView)view.findViewById(R.id.score5);
        one6=(TextView)view.findViewById(R.id.score6);
        one7=(TextView)view.findViewById(R.id.score7);
        one8=(TextView)view.findViewById(R.id.score8);
        one9=(TextView)view.findViewById(R.id.score9);

        twoone=((MainActivity)getActivity()).twoone;
        twotwo=((MainActivity)getActivity()).twotwo;
        throne=((MainActivity)getActivity()).throne;
        thrtwo=((MainActivity)getActivity()).thrtwo;
        artpe=((MainActivity)getActivity()).artpe;
        artpe1=((MainActivity)getActivity()).artpe1;
        artpe2=((MainActivity)getActivity()).artpe2;
        artpe3=((MainActivity)getActivity()).artpe3;
        artpe4=((MainActivity)getActivity()).artpe4;
        sangbong=((MainActivity)getActivity()).sangbong;
        sangchul=((MainActivity)getActivity()).sangchul;
        sanghak=((MainActivity)getActivity()).sanghak;
        double sumsumsum=artpe1+artpe2+artpe3;
        chaeyae=(Double)(artpe1+artpe2+artpe3+artpe4);
        chaeyae=Math.round(chaeyae*1000.0)/1000.0;
        one1.setText(Double.toString(twoone));
        one2.setText(Double.toString(twotwo));
        one3.setText(Double.toString(throne));
        one4.setText(Double.toString(thrtwo));
        one5.setText(Double.toString(chaeyae));
        one6.setText(Double.toString(sangchul));
        one7.setText(Double.toString(sangbong));
        one8.setText(Double.toString(sanghak));


        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double stringstring=twoone+twotwo+throne+thrtwo+chaeyae+sangchul+sangbong+sanghak;
                one9.setText(Double.toString(Math.round(stringstring*1000.0)/1000.0));
            }
        });
        Button button3 = view.findViewById(R.id.greatbutton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NewActivity0.class);
                intent.putExtra("one",twoone);
                intent.putExtra("two",twotwo);
                intent.putExtra("thr",throne);
                intent.putExtra("fou",thrtwo);
                startActivity(intent);
                /*((NewActivity0)getActivity()).one=twoone;
                ((NewActivity0)getActivity()).two=twotwo;
                ((NewActivity0)getActivity()).thr=throne;
                ((NewActivity0)getActivity()).fou=thrtwo;*/
                /*intent.putExtra("one",1.0);
                intent.putExtra("one2",2.0);
                intent.putExtra("one3",3.0);
                intent.putExtra("one4",4.0);*/
            }
        });

        return view;
    }

}
