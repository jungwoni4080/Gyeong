package org.techtown.gyeongcopy;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.techtown.gyeongcopy.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_5 extends Fragment {
    double ecus;
    int bongsajumsu;
    double one,two,three,four,five,six,seven,eight,nine;
    TextView textView, textView2,result1,result2,textView45;
    EditText first,second,third,fourth,fifth,sixth;
    TextView printscore1,printscore2,printscore3;
    String[] items= {"0회","1회","2회","3회","4회","5회","6회 이상"};
    String[] items3= {"0회","1회","2회","3회","4회","5회","6회 이상"};
    String[] items5= {"0회","1회","2회","3회","4회","5회","6회 이상"};

    public Fragment_5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fragment_5,null);



        first = (EditText)view.findViewById(R.id.first);
        second = (EditText)view.findViewById(R.id.second);
        third = (EditText)view.findViewById(R.id.third);
        fourth = (EditText)view.findViewById(R.id.fourth);
        fifth = view.findViewById(R.id.fifth);
        sixth = view.findViewById(R.id.sixth);
        printscore1 = view.findViewById(R.id.printscore1);
        printscore2 = view.findViewById(R.id.printscore2);
        printscore3 = view.findViewById(R.id.printscore3);
        final Spinner spinner1 = (Spinner)view.findViewById(R.id.spinner1);
        final Spinner spinner3 = (Spinner)view.findViewById(R.id.spinner3);
        final Spinner spinner5 = (Spinner)view.findViewById(R.id.spinner5);
        ArrayAdapter<String> adapterSpinner1 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        ArrayAdapter<String> adapterSpinner3 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        ArrayAdapter<String> adapterSpinner5 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        ArrayAdapter<String> adapterSpinner8 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        ArrayAdapter<String> adapterSpinner9 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        adapterSpinner1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterSpinner3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterSpinner5.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterSpinner8.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterSpinner9.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapterSpinner1);
        spinner3.setAdapter(adapterSpinner3);
        spinner5.setAdapter(adapterSpinner5);
        adapterSpinner1.addAll(items);
        adapterSpinner3.addAll(items3);
        adapterSpinner5.addAll(items5);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner1.getSelectedItem().toString();
                if(location==items[0]){
                    one = 6;
                }
                else if(location==items[1]){
                    one = 5.4;
                }
                else if(location==items[2]){
                    one = 4.8;
                }
                else if(location==items[3]){
                    one = 4.2;
                }
                else if(location==items[4]){
                    one = 3.6;
                }
                else if(location==items[5]){
                    one = 3;
                }
                else {
                    one = 2.4;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner3.getSelectedItem().toString();
                if(location==items[0]){
                    three = 7;
                }
                else if(location==items[1]){
                    three = 6.3;
                }
                else if(location==items[2]){
                    three = 5.6;
                }
                else if(location==items[3]){
                    three = 4.9;
                }
                else if(location==items[4]){
                    three = 4.2;
                }
                else if(location==items[5]){
                    three = -4;
                }
                else {
                    three = 3.6;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner5.getSelectedItem().toString();
                if(location==items5[0]){
                    five = 7;
                }
                else if(location==items5[1]){
                    five = 6.3;
                }
                else if(location==items5[2]){
                    five = 5.6;
                }
                else if(location==items5[3]){
                    five = 4.9;
                }
                else if(location==items5[4]){
                    five = 4.2;
                }
                else if(location==items5[5]){
                    five = 3.6;
                }
                else {
                    five = 2.8;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });


        //int bongsa = Integer.parseInt(fourth.getText().toString());
        /*if(bongsa<=4){
            bongsajumsu=8;
        }
        else if(bongsa<=6){
            bongsajumsu=9;
        }
        else if(bongsa<=14){
            bongsajumsu=10;
        }
        else if(bongsa<=19){
            bongsajumsu=11;
        }
        else if(bongsa<=24){
            bongsajumsu=12;
        }
        else if(bongsa<=29){
            bongsajumsu=13;
        }
        else if(bongsa<=34){
            bongsajumsu=14;
        }
        else if(bongsa<=39){
            bongsajumsu=15;
        }
        else if(bongsa<=44){
            bongsajumsu=16;
        }
        else if(bongsa<=49){
            bongsajumsu=17;
        }
        else if(bongsa<=54){
            bongsajumsu=18;
        }
        else if(bongsa<=59){
            bongsajumsu=19;
        }
        else{
            bongsajumsu=20;
        }*/
        int sang = Integer.parseInt(fifth.getText().toString());
        int imwon = Integer.parseInt(sixth.getText().toString());
        //int bongsa = Integer.parseInt(fourth.getText().toString());
        //bongsajumsu=bongsa1(bongsa);
        final int[] yesstart = {1};
        Button btn_server =view.findViewById(R.id.button);
        btn_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final int bongsa = Integer.parseInt(fourth.getText().toString());
                //final이 뭔진 모르겠다
                /*if(yesstart[0] ==1) {
                    int bongsa = Integer.parseInt(fourth.getText().toString());
                    bongsajumsu = bongsa1(bongsa);
                    printscore2.setText(Integer.toString(bongsajumsu));
                    ((MainActivity) getActivity()).sangbong = bongsajumsu;
                    yesstart[0] =0;
                }*/
                int bongsa = Integer.parseInt(fourth.getText().toString());
                bongsajumsu=bongsa2(bongsa);
                /*Queen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int bongsa = Integer.parseInt(fourth.getText().toString());
                        switch (checkedId){
                            case R.id.bob:
                                bongsajumsu=bongsa1(bongsa);
                                break;
                            case R.id.dylan:
                                bongsajumsu=bongsa2(bongsa);
                                break;
                        }
                    }
                });*/
                /*if(bongsa<=4){
                    bongsajumsu=8;
                }
                else if(bongsa<=6){
                    bongsajumsu=9;
                }
                else if(bongsa<=14){
                    bongsajumsu=10;
                }
                else if(bongsa<=19){
                    bongsajumsu=11;
                }
                else if(bongsa<=24){
                    bongsajumsu=12;
                }
                else if(bongsa<=29){
                    bongsajumsu=13;
                }
                else if(bongsa<=34){
                    bongsajumsu=14;
                }
                else if(bongsa<=39){
                    bongsajumsu=15;
                }
                else if(bongsa<=44){
                    bongsajumsu=16;
                }
                else if(bongsa<=49){
                    bongsajumsu=17;
                }
                else if(bongsa<=54){
                    bongsajumsu=18;
                }
                else if(bongsa<=59){
                    bongsajumsu=19;
                }
                else{
                    bongsajumsu=20;
                }*/
                int sang = Integer.parseInt(fifth.getText().toString());
                int imwon = Integer.parseInt(sixth.getText().toString());
                int chul1 = Integer.parseInt(first.getText().toString())/3;
                int chul2 = Integer.parseInt(second.getText().toString())/3;
                int chul3 = Integer.parseInt(third.getText().toString())/3;
                double one1=one;
                double one2=three;
                double one3=five;
                double hakgyo = 8+imwon*0.1+sang*0.5;
                if(hakgyo>10){
                    hakgyo=10;
                }
                one1=one1-chul1*0.7;
                one2=one2-chul2*0.7;
                one3=one3-chul3*0.7;

                printscore1.setText(Double.toString(one1+one2+one3));
                ((MainActivity)getActivity()).sangchul=one1+one2+one3;
                printscore2.setText(Integer.toString(bongsajumsu));
                ((MainActivity)getActivity()).sangbong=bongsajumsu;
                printscore3.setText(Double.toString(hakgyo));
                ((MainActivity)getActivity()).sanghak=hakgyo;
            }
        });


        return view;
    }

    public int bongsa1(int bongsa){
        if(bongsa<=4){
            return 8;
        }
        else if(bongsa<=6){
            return 9;
        }
        else if(bongsa<=14){
            return 10;
        }
        else if(bongsa<=19){
            return 11;
        }
        else if(bongsa<=24){
            return 12;
        }
        else if(bongsa<=29){
            return 13;
        }
        else if(bongsa<=34){
            return 14;
        }
        else if(bongsa<=39){
            return 15;
        }
        else if(bongsa<=44){
            return 16;
        }
        else if(bongsa<=49){
            return 17;
        }
        else if(bongsa<=54){
            return 18;
        }
        else if(bongsa<=59){
            return 19;
        }
        else{
            return 20;
        }

    }
    public int bongsa2(int bongsa){
        if(bongsa<=4){
            return 12;
        }
        else if(bongsa<=9){
            return 13;
        }
        else if(bongsa<=14){
            return 14;
        }
        else if(bongsa<=19){
            return 15;
        }
        else if(bongsa<=24){
            return 16;
        }
        else if(bongsa<=29){
            return 17;
        }
        else if(bongsa<=34){
            return 18;
        }
        else if(bongsa<=39){
            return 19;
        }
        else{
            return 20;
        }

    }

}
