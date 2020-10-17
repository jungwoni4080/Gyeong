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
import android.widget.Spinner;
import android.widget.TextView;

import org.techtown.gyeongcopy.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_4 extends Fragment {
    EditText score,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11; //원점수를 가져옴
    EditText avg1,avg2,avg3,avg4,avg5,avg6,avg7,avg8,avg9,avg10,avg11; //평균을 가져움
    EditText stan1,stan2,stan3,stan4,stan5,stan6,stan7,stan8,stan9,stan10,stan11; //표준편차 가져옴
    EditText ac12, ac13,ac14;
    TextView ac,ac2,ac3,ac4,ac5,ac6,ac7,ac8,ac9,ac10,ac11,realscore1,realscore2; //성취도(Textview)랑, 일반 교과점수, 예체 교과점수 가져옴
    int how_many_subjects=0; //과목이 몇개인지 셈
    int iscore,iscore2,iscore3,iscore4,iscore5,iscore6,iscore7,iscore8,iscore9,iscore10,iscore11; //score을 숫자값으로 바꿔 넣을 곳이다


    double iavg,iavg2,iavg3,iavg4,iavg5,iavg6,iavg7,iavg8,iavg9,iavg10,iavg11; //avg를 숫자로 바꿔서 넣을 곳이다
    double istan,istan2,istan3,istan4,istan5,istan6,istan7,istan8,istan9,istan10,istan11; //stan(편차)값을 숫자로 바꿔 넣을 곳이다.

    //미술, 체육, 음악의 스피너(여러 가지 중에 선택)하도록 만들음
    int hmA=0,hmB=0,hmC=0;
    String items[] = {"A","B","C"};
    String items2[] = {"A","B","C"};
    String items3[] = {"A","B","C"};
    String iac12,iac13,iac14;
    //char ch,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10,ch11;
    public Fragment_4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_4, container, false);
        score = view.findViewById(R.id.score);//모든 원점수를 받아온다.
        score2 = view.findViewById(R.id.score2);
        score3 = view.findViewById(R.id.score3);
        score4 = view.findViewById(R.id.score4);
        score5 = view.findViewById(R.id.score5);
        score6 = view.findViewById(R.id.score6);
        score7 = view.findViewById(R.id.score7);
        score8 = view.findViewById(R.id.score8);
        score9 = view.findViewById(R.id.score9);
        score10 = view.findViewById(R.id.score10);
        score11 = view.findViewById(R.id.score11);
        avg1 = view.findViewById(R.id.avg1); //모든 평균을 받아온다
        avg2 = view.findViewById(R.id.avg2);
        avg3 = view.findViewById(R.id.avg3);
        avg4 = view.findViewById(R.id.avg4);
        avg5 = view.findViewById(R.id.avg5);
        avg6 = view.findViewById(R.id.avg6);
        avg7 = view.findViewById(R.id.avg7);
        avg8 = view.findViewById(R.id.avg8);
        avg9 = view.findViewById(R.id.avg9);
        avg10 = view.findViewById(R.id.avg10);
        avg11 = view.findViewById(R.id.avg11);
        stan1 = view.findViewById(R.id.stan1);//모든 표준편차를 받아온다.
        stan2 = view.findViewById(R.id.stan2);
        stan3 = view.findViewById(R.id.stan3);
        stan4 = view.findViewById(R.id.stan4);
        stan5 = view.findViewById(R.id.stan5);
        stan6 = view.findViewById(R.id.stan6);
        stan7 = view.findViewById(R.id.stan7);
        stan8 = view.findViewById(R.id.stan8);
        stan9 = view.findViewById(R.id.stan9);
        stan10 = view.findViewById(R.id.stan10);
        stan11 = view.findViewById(R.id.stan11);
        ac = view.findViewById(R.id.ac);// 모든 성취도를 받아온다.
        ac2 = view.findViewById(R.id.ac2);
        ac3 = view.findViewById(R.id.ac3);
        ac4 = view.findViewById(R.id.ac4);
        ac5 = view.findViewById(R.id.ac5);
        ac6 = view.findViewById(R.id.ac6);
        ac7 = view.findViewById(R.id.ac7);
        ac8 = view.findViewById(R.id.ac8);
        ac9 = view.findViewById(R.id.ac9);
        ac10 = view.findViewById(R.id.ac10);
        ac11 = view.findViewById(R.id.ac11);
        realscore1 = view.findViewById(R.id.realscore);//일반 교과 점수를 넣을 공간
        realscore2= view.findViewById(R.id.realscore2);//예체 교과 점수를 넣을 공간

//스피너 준비 과정
        final Spinner spinner1=view.findViewById(R.id.spinner);
        final Spinner spinner2=view.findViewById(R.id.spinner2);
        final Spinner spinner3=view.findViewById(R.id.spinner3);
        ArrayAdapter<String> adapterSpinner1 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        ArrayAdapter<String> adapterSpinner2 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        ArrayAdapter<String> adapterSpinner3 = new ArrayAdapter(this.getActivity(), R.layout.spinner_item);
        adapterSpinner1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterSpinner2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterSpinner3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapterSpinner1);
        spinner2.setAdapter(adapterSpinner2);
        spinner3.setAdapter(adapterSpinner3);
        adapterSpinner1.addAll(items);//스피너에 들어갈 요소들을 넣음.
        adapterSpinner2.addAll(items2);
        adapterSpinner3.addAll(items3);

        //스피너에 선택된 값에 따라 성취도 값이 선택됨
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner1.getSelectedItem().toString();
                if(location==items[0]){
                    iac12="A";
                }
                else if(location==items[1]){
                    iac12="B";
                }
                else {
                    iac12="C";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //성취도에 선택된 것에 따라 성취도 결정됨
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner2.getSelectedItem().toString();
                if(location==items2[0]){
                    iac13="A";
                }
                else if(location==items2[1]){
                    iac13="B";
                }
                else {
                    iac13="C";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //스피너에 선택된 것에 따라 성취도가 결정됨
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = spinner3.getSelectedItem().toString();
                if(location==items3[0]){
                    iac14="A";
                }
                else if(location==items3[1]){
                    iac14="B";
                }
                else {
                    iac14="C";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btn_server = (Button) view.findViewById(R.id.button);
        btn_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                how_many_subjects=0;
                if(score.length()==0) iscore=0;//점수가 비어있다면 없는 과목으로 치고, 아니라면 점수 값을 넣는다.
                else{
                    iscore = Integer.parseInt(score.getText().toString()); //점수 정의
                }
                if(score2.length()==0) iscore2=0;
                else{
                    iscore2 = Integer.parseInt(score2.getText().toString());}
                if(score3.length()==0) iscore3=0;
                else{
                    iscore3 = Integer.parseInt(score3.getText().toString());}
                if(score4.length()==0) iscore4=0;
                else{
                    iscore4 = Integer.parseInt(score4.getText().toString());}
                if(score5.length()==0) iscore5=0;
                else{
                    iscore5 = Integer.parseInt(score5.getText().toString());}
                if(score6.length()==0) iscore6=0;
                else{
                    iscore6 = Integer.parseInt(score6.getText().toString());}
                if(score7.length()==0) iscore7=0;
                else{
                    iscore7 = Integer.parseInt(score7.getText().toString());}
                if(score8.length()==0) iscore8=0;
                else{
                    iscore8 = Integer.parseInt(score8.getText().toString());}
                if(score9.length()==0) iscore9=0;
                else{
                    iscore9 = Integer.parseInt(score9.getText().toString());}
                if(score10.length()==0) iscore10=0;
                else{
                    iscore10 = Integer.parseInt(score10.getText().toString());}
                if(score11.length()==0) iscore11=0;
                else{
                    iscore11 = Integer.parseInt(score11.getText().toString());}

                String iacscore = whatschar(iscore);//점수에 따라 성취도를 정해줌
                String iacscore2 = whatschar(iscore2);
                String iacscore3 = whatschar(iscore3);
                String iacscore4 = whatschar(iscore4);
                String iacscore5 = whatschar(iscore5);
                String iacscore6 = whatschar(iscore6);
                String iacscore7 = whatschar(iscore7);
                String iacscore8 = whatschar(iscore8);
                String iacscore9 = whatschar(iscore9);
                String iacscore10 = whatschar(iscore10);
                String iacscore11 = whatschar(iscore11);

                ac.setText(iacscore); //성취도 TextView에다 성취도를 넣음
                ac2.setText(iacscore2);
                ac3.setText(iacscore3);
                ac4.setText(iacscore4);
                ac5.setText(iacscore5);
                ac6.setText(iacscore6);
                ac7.setText(iacscore7);
                ac8.setText(iacscore8);
                ac9.setText(iacscore9);
                ac10.setText(iacscore10);
                ac11.setText(iacscore11);

                int iactoint = chartoint(iacscore);//성취도 점수를 구해줌
                int iactoint2 = chartoint(iacscore2);
                int iactoint3 = chartoint(iacscore3);
                int iactoint4 = chartoint(iacscore4);
                int iactoint5 = chartoint(iacscore5);
                int iactoint6 = chartoint(iacscore6);
                int iactoint7 = chartoint(iacscore7);
                int iactoint8 = chartoint(iacscore8);
                int iactoint9 = chartoint(iacscore9);
                int iactoint10 = chartoint(iacscore10);
                int iactoint11 = chartoint(iacscore11);
                int Asum=iactoint+iactoint2+iactoint3+iactoint4+iactoint5+iactoint6+iactoint7+iactoint8+iactoint9+iactoint10+iactoint11;
                //ac.setText(Character((char)(70-)));
                if(avg1.length()==0) iavg=0;//평균값이 비어있으면 없는 과목 처리하고, 값이 있다면 값을 넣는다
                else {
                    iavg = Double.parseDouble(avg1.getText().toString());//평균과 표준편차 정의
                }
                if(avg2.length()==0) iavg2=0;
                else{
                    iavg2 = Double.parseDouble(avg2.getText().toString());}
                if(avg3.length()==0) iavg3=0;
                else{
                    iavg3 = Double.parseDouble(avg3.getText().toString());}
                if(avg4.length()==0) iavg4=0;
                else{
                    iavg4 = Double.parseDouble(avg4.getText().toString());}
                if(avg5.length()==0) iavg5=0;
                else{
                    iavg5 = Double.parseDouble(avg5.getText().toString());}
                if(avg6.length()==0) iavg6=0;
                else{
                    iavg6 = Double.parseDouble(avg6.getText().toString());}
                if(avg7.length()==0) iavg7=0;
                else{
                    iavg7 = Double.parseDouble(avg7.getText().toString());}
                if(avg8.length()==0) iavg8=0;
                else{
                    iavg8 = Double.parseDouble(avg8.getText().toString());}
                if(avg9.length()==0) iavg9=0;
                else{
                    iavg9 = Double.parseDouble(avg9.getText().toString());}
                if(avg10.length()==0) iavg10=0;
                else{
                    iavg10 = Double.parseDouble(avg10.getText().toString());}
                if(avg11.length()==0) iavg11=0;
                else{
                    iavg11 = Double.parseDouble(avg11.getText().toString());}

                if(stan1.length()==0) istan=0;//표준편차 값이 비어있다면 없는 과목 처리하고, 값이 있다면 넣는다
                else{
                    istan = Double.parseDouble(stan1.getText().toString());}
                if(stan2.length()==0) istan2=0;
                else{
                    istan2 = Double.parseDouble(stan2.getText().toString());}
                if(stan3.length()==0) istan3=0;
                else{
                    istan3 = Double.parseDouble(stan3.getText().toString());}
                if(stan4.length()==0) istan4=0;
                else{
                    istan4 = Double.parseDouble(stan4.getText().toString());}
                if(stan5.length()==0) istan5=0;
                else{
                    istan5 = Double.parseDouble(stan5.getText().toString());}
                if(stan6.length()==0) istan6=0;
                else{
                    istan6 = Double.parseDouble(stan6.getText().toString());}
                if(stan7.length()==0) istan7=0;
                else{
                    istan7 = Double.parseDouble(stan7.getText().toString());}
                if(stan8.length()==0) istan8=0;
                else{
                    istan8 = Double.parseDouble(stan8.getText().toString());}
                if(stan9.length()==0) istan9=0;
                else{
                    istan9 = Double.parseDouble(stan9.getText().toString());}
                if(stan10.length()==0) istan10=0;
                else{
                    istan10 = Double.parseDouble(stan10.getText().toString());}

                if(stan11.length()==0) istan11=0;
                else{
                    istan11 = Double.parseDouble(stan11.getText().toString());}
                int iactoint12 = howmany1(iac12);//예체 과목의 성취도 점수를 따로 계산
                int iactoint13 = howmany1(iac13);
                int iactoint14 = howmany1(iac14);
                double realscore2sum = 10+20*((double)(iactoint12+iactoint13+iactoint14)/9);
                realscore2sum=Math.round(realscore2sum*100000.0)/100000.0;
                howmany(iscore); //몇 개의 과목이 있는지 확인
                howmany(iscore2);
                howmany(iscore3);
                howmany(iscore4);
                howmany(iscore5);
                howmany(iscore6);
                howmany(iscore7);
                howmany(iscore8);
                howmany(iscore9);
                howmany(iscore10);
                howmany(iscore11);
                ((MainActivity)getActivity()).artpe+=realscore2sum;
                ((MainActivity)getActivity()).artpe4=(Double)realscore2sum/4;//예체 과목의 점수를Mainactivity로 값을 넘겨서, 처음 창에서 최종 점수를 볼 수 있게 함
                realscore2.setText(Double.toString((Double)realscore2sum/4));//예체 과목 점수를 결과값에 넣는다
                realscore2sum=0;
                if(how_many_subjects!=0){ //과목이 하나 이상이여야지 실행됨
                    //일반 교과 점수를 구하는 과정
                    double A =(double)Asum/how_many_subjects;
                    int scoresum = iscore+iscore2+iscore3+iscore4+iscore5+iscore6+iscore7+iscore8+iscore9+iscore10+iscore11;
                    double avgsum = iavg+iavg2+iavg3+iavg4+iavg5+iavg6+iavg7+iavg8+iavg9+iavg10+iavg11;
                    double stansum = istan+istan2+istan3+istan4+istan5+istan6+istan7+istan8+istan9+istan10+istan11;
                    double Z = (scoresum-avgsum)/stansum;
                    Z=Math.round(Z*100.0)/100.0;
                    double FZ=NORMSDIST(Z);
                    FZ =Math.round(FZ*100000000.0)/100000000.0;
                    double realscorewow=10+A * 2 +FZ*10;
                    realscorewow = Math.round(realscorewow*1000.0)/1000.0;
                    realscore1.setText(Double.toString(realscorewow));//결과값에 일반 교과 점수를 집어넣음
                    ((MainActivity)getActivity()).thrtwo=realscorewow;//MainActivity에 값을 넘겨서 최종 결과 창에서 값을 받을 수 있게 함

                }
                //realscore1.setText(Integer.toString(how_many_subjects));

            }
        });
        Button button6 = view.findViewById(R.id.button6);//그래프로 넘어가는 버튼
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(score.length()==0) iscore=0;
                else{
                    iscore = Integer.parseInt(score.getText().toString()); //점수 정의
                }
                if(score2.length()==0) iscore2=0;
                else{
                    iscore2 = Integer.parseInt(score2.getText().toString());}
                if(score3.length()==0) iscore3=0;
                else{
                    iscore3 = Integer.parseInt(score3.getText().toString());}
                if(score4.length()==0) iscore4=0;
                else{
                    iscore4 = Integer.parseInt(score4.getText().toString());}
                if(score5.length()==0) iscore5=0;
                else{
                    iscore5 = Integer.parseInt(score5.getText().toString());}
                if(score6.length()==0) iscore6=0;
                else{
                    iscore6 = Integer.parseInt(score6.getText().toString());}
                if(score7.length()==0) iscore7=0;
                else{
                    iscore7 = Integer.parseInt(score7.getText().toString());}
                if(score8.length()==0) iscore8=0;
                else{
                    iscore8 = Integer.parseInt(score8.getText().toString());}
                if(score9.length()==0) iscore9=0;
                else{
                    iscore9 = Integer.parseInt(score9.getText().toString());}
                if(score10.length()==0) iscore10=0;
                else{
                    iscore10 = Integer.parseInt(score10.getText().toString());}
                if(score11.length()==0) iscore11=0;
                else{
                    iscore11 = Integer.parseInt(score11.getText().toString());}

                if(avg1.length()==0) iavg=0;
                else {
                    iavg = Double.parseDouble(avg1.getText().toString());//평균과 표준편차 정의
                }
                if(avg2.length()==0) iavg2=0;
                else{
                    iavg2 = Double.parseDouble(avg2.getText().toString());}
                if(avg3.length()==0) iavg3=0;
                else{
                    iavg3 = Double.parseDouble(avg3.getText().toString());}
                if(avg4.length()==0) iavg4=0;
                else{
                    iavg4 = Double.parseDouble(avg4.getText().toString());}
                if(avg5.length()==0) iavg5=0;
                else{
                    iavg5 = Double.parseDouble(avg5.getText().toString());}
                if(avg6.length()==0) iavg6=0;
                else{
                    iavg6 = Double.parseDouble(avg6.getText().toString());}
                if(avg7.length()==0) iavg7=0;
                else{
                    iavg7 = Double.parseDouble(avg7.getText().toString());}
                if(avg8.length()==0) iavg8=0;
                else{
                    iavg8 = Double.parseDouble(avg8.getText().toString());}
                if(avg9.length()==0) iavg9=0;
                else{
                    iavg9 = Double.parseDouble(avg9.getText().toString());}
                if(avg10.length()==0) iavg10=0;
                else{
                    iavg10 = Double.parseDouble(avg10.getText().toString());}
                if(avg11.length()==0) iavg11=0;
                else{
                    iavg11 = Double.parseDouble(avg11.getText().toString());}

                if(stan1.length()==0) istan=0;
                else{
                    istan = Double.parseDouble(stan1.getText().toString());}
                if(stan2.length()==0) istan2=0;
                else{
                    istan2 = Double.parseDouble(stan2.getText().toString());}
                if(stan3.length()==0) istan3=0;
                else{
                    istan3 = Double.parseDouble(stan3.getText().toString());}
                if(stan4.length()==0) istan4=0;
                else{
                    istan4 = Double.parseDouble(stan4.getText().toString());}
                if(stan5.length()==0) istan5=0;
                else{
                    istan5 = Double.parseDouble(stan5.getText().toString());}
                if(stan6.length()==0) istan6=0;
                else{
                    istan6 = Double.parseDouble(stan6.getText().toString());}
                if(stan7.length()==0) istan7=0;
                else{
                    istan7 = Double.parseDouble(stan7.getText().toString());}
                if(stan8.length()==0) istan8=0;
                else{
                    istan8 = Double.parseDouble(stan8.getText().toString());}
                if(stan9.length()==0) istan9=0;
                else{
                    istan9 = Double.parseDouble(stan9.getText().toString());}
                if(stan10.length()==0) istan10=0;
                else{
                    istan10 = Double.parseDouble(stan10.getText().toString());}

                if(stan11.length()==0) istan11=0;
                else{
                    istan11 = Double.parseDouble(stan11.getText().toString());}
//값을 그래프 Fragment로 보낸다.
                Intent intent = new Intent(getActivity(),NewActivity4.class);
                intent.putExtra("one",(double)iscore);
                intent.putExtra("two",(double)iscore2);
                intent.putExtra("thr",(double)iscore3);
                intent.putExtra("fou",(double)iscore4);
                intent.putExtra("fiv",(double)iscore5);
                intent.putExtra("six",(double)iscore6);
                intent.putExtra("sev",(double)iscore7);
                intent.putExtra("eig",(double)iscore8);
                intent.putExtra("nin",(double)iscore9);
                intent.putExtra("ten",(double)iscore10);
                intent.putExtra("ele",(double)iscore11);

                intent.putExtra("one1",(double)iavg);
                intent.putExtra("two1",(double)iavg2);
                intent.putExtra("thr1",(double)iavg3);
                intent.putExtra("fou1",(double)iavg4);
                intent.putExtra("fiv1",(double)iavg5);
                intent.putExtra("six1",(double)iavg6);
                intent.putExtra("sev1",(double)iavg7);
                intent.putExtra("eig1",(double)iavg8);
                intent.putExtra("nin1",(double)iavg9);
                intent.putExtra("ten1",(double)iavg10);
                intent.putExtra("ele1",(double)iavg11);

                intent.putExtra("one2",(double)istan);
                intent.putExtra("two2",(double)istan2);
                intent.putExtra("thr2",(double)istan3);
                intent.putExtra("fou2",(double)istan4);
                intent.putExtra("fiv2",(double)istan5);
                intent.putExtra("six2",(double)istan6);
                intent.putExtra("sev2",(double)istan7);
                intent.putExtra("eig2",(double)istan8);
                intent.putExtra("nin2",(double)istan9);
                intent.putExtra("ten2",(double)istan10);
                intent.putExtra("ele2",(double)istan11);

                startActivity(intent);
            }
        });


        how_many_subjects=0;
        return view;
    }


    public static double NORMSDIST(double z) { //Normdist함수를 사용하기 위해 두었다.
        // this guards against overflow
        if (z > 6)
            return 1;
        if (z < -6)
            return 0;

        double  gamma = 0.231641900,
                a1 = 0.319381530,
                a2 = -0.356563782,
                a3 = 1.781477973,
                a4 = -1.821255978,
                a5 = 1.330274429;

        double x = Math.abs(z);
        double t = 1 / (1 + gamma * x);
        double n = 1
                - (1 / (Math.sqrt(2 * Math.PI)) * Math.exp(-z * z / 2))
                * (a1 * t + a2 * Math.pow(t, 2) + a3 * Math.pow(t, 3) + a4
                * Math.pow(t, 4) + a5 * Math.pow(t, 5));
        if (z < 0)
            return 1.0 - n;
        return n;
    }
    public void howmany(int score){
        if(score>0){
            how_many_subjects= how_many_subjects+1;
        }
    }

    /*public int whatsscore(int score){
        if(score>=90){
            return 5;
        }
        else if(score>=80){
            return 4;
        }
        else if(score>=70){
            return 3;
        }
        else if(score>=60){
            return 2;
        }
        else if(score>=50){
            return 1;
        }
        else if(score==0){
            return
        }
        else{
            return 0;
        }

    }*/
    public String whatschar(int score){
        if(score>=90){
            return "A";
        }
        else if(score>=80){
            return "B";
        }
        else if(score>=70){
            return "C";
        }
        else if(score>=60){
            return "D";
        }
        else if(score>=50){
            return "E";
        }
        else if(score==0){
            return "X";
        }
        else{
            return "F";
        }
    }
    public int chartoint(String str){
        if(str.contains("A")){
            return 5;
        }
        else if(str.contains("B")){
            return 4;
        }
        else if(str.contains("C")){
            return 3;
        }
        else if(str.contains("D")){
            return 2;
        }
        else if(str.contains("E")){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int howmany1(String str){
        if(str.contains("A")) return 3;
        else if(str.contains("B")) return 2;
        else return 1;
    }
}

