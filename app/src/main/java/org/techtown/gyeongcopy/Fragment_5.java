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
    String[] items= {"0회","1회","2회","3회","4회","5회","6회 이상"}; //후에 스피너에 들어갈 아이템이다
    String[] items3= {"0회","1회","2회","3회","4회","5회","6회 이상"};
    String[] items5= {"0회","1회","2회","3회","4회","5회","6회 이상"};

    public Fragment_5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fragment_5,null);



        first = (EditText)view.findViewById(R.id.first); //필요한 모든것을 가져온다
        second = (EditText)view.findViewById(R.id.second);
        third = (EditText)view.findViewById(R.id.third);
        fourth = (EditText)view.findViewById(R.id.fourth);
        fifth = view.findViewById(R.id.fifth);
        sixth = view.findViewById(R.id.sixth);
        printscore1 = view.findViewById(R.id.printscore1);
        printscore2 = view.findViewById(R.id.printscore2);
        printscore3 = view.findViewById(R.id.printscore3);
        final Spinner spinner1 = (Spinner)view.findViewById(R.id.spinner1);//스피너 준비작업
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
        adapterSpinner1.addAll(items); //스피너에 들어갈 이름들
        adapterSpinner3.addAll(items3);
        adapterSpinner5.addAll(items5);

        //무단 결석 수를 선택
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner1.getSelectedItem().toString();
                if(location==items[0]){ //1학년 무단 결석 수 선택
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
        //무단 결석 수
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner3.getSelectedItem().toString();
                if(location==items[0]){ //2학년 무단 결석 수 선택
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
                    three = 3.6;
                }
                else {
                    three = 2.8;
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
                if(location==items5[0]){ //3학년 무단결석 수 선택
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

        //구 봉사점수 시스템
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
        //int bongsa = Integer.parseInt(fourth.getText().toString());
        //bongsajumsu=bongsa1(bongsa);
        final int[] yesstart = {1};
        Button btn_server =view.findViewById(R.id.button);
        btn_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //라디오 버튼 해제
                //final int bongsa = Integer.parseInt(fourth.getText().toString());
                /*if(yesstart[0] ==1) {
                    int bongsa = Integer.parseInt(fourth.getText().toString());
                    bongsajumsu = bongsa1(bongsa);
                    printscore2.setText(Integer.toString(bongsajumsu));
                    ((MainActivity) getActivity()).sangbong = bongsajumsu;
                    yesstart[0] =0;
                }*/
                int bongsa = Integer.parseInt(fourth.getText().toString());
                bongsajumsu=bongsa2(bongsa);
                //라디오 버튼 해제
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
                //상 임원 개수, 무단 지각·조퇴·결과 수를 3으로 나눔(3번에 하나의 무단 결석으로 인정)
                int sang = Integer.parseInt(fifth.getText().toString());
                int imwon = Integer.parseInt(sixth.getText().toString());
                int chul1 = Integer.parseInt(first.getText().toString())/3;
                int chul2 = Integer.parseInt(second.getText().toString())/3;
                int chul3 = Integer.parseInt(third.getText().toString())/3;
                double one1=one; //1학년 무단 결석 점수
                double one2=three; //2학년 무단 결석 점수
                double one3=five; //3학년 무단 결석 점수
                double hakgyo = 8+imwon*0.1+sang*0.5; //학교활동 점수 계산
                if(hakgyo>10){ //여러가지 이유로 10점이 넘을경우 10점으로 취급
                    hakgyo=10;
                }
                one1=one1-chul1*0.7; //무단 결석과 무단 결과를 같이 계산함 (출결 점수 계산)
                one2=one2-chul2*0.7;
                one3=one3-chul3*0.7;

                printscore1.setText(Double.toString(one1+one2+one3)); //출결 점수에 값 넣기
                ((MainActivity)getActivity()).sangchul=one1+one2+one3; // 최종 결과 창에 값 보냄
                printscore2.setText(Integer.toString(bongsajumsu)); //봉사점수에 값 넣기
                ((MainActivity)getActivity()).sangbong=bongsajumsu; // 최종 결과 창에 값 보냄
                printscore3.setText(Double.toString(hakgyo)); // 학교활동에 값 넣기
                ((MainActivity)getActivity()).sanghak=hakgyo; // 최종 결과 창에 값 보냄
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
