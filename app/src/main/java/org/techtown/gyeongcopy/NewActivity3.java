package org.techtown.gyeongcopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class NewActivity3 extends AppCompatActivity {
    double scores[] = new double[11];
    //표시될 수 있는 과목의 배열
    double guk,doduk,sahwe,yuck,math,sci,giga,eng,one1,one2,one3;
    String xxx[] = new String[] {"국어","도덕","사회","역사","수학","과학","기가","영어","선택","선택2","선택3"};
    int k=0;
    //과목들의 평균, 표준편차, 점수 등
    double avg[] = new double[11];
    double stan[] = new double[11];
    String values[] = new String[11];
    TextView textView;
    int l=0;
    LineChart chart;//라인차트를 이용해 비교해줌
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);
        getSupportActionBar().setTitle("3-1 그래프");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        guk = intent.getDoubleExtra("one", 0.0); //그래프 값
        doduk = intent.getDoubleExtra("two", 0.0);
        sahwe = intent.getDoubleExtra("thr", 0.0);
        yuck = intent.getDoubleExtra("fou", 0.0);
        math = intent.getDoubleExtra("fiv", 0.0);
        sci = intent.getDoubleExtra("six", 0.0);
        giga = intent.getDoubleExtra("sev", 0.0);
        eng = intent.getDoubleExtra("eig", 0.0);
        one1 = intent.getDoubleExtra("nin", 0.0);
        one2 = intent.getDoubleExtra("ten", 0.0);
        one3 = intent.getDoubleExtra("ele", 0.0);
        avg[0] = intent.getDoubleExtra("one1",0.0);
        avg[1] = intent.getDoubleExtra("two1",0.0);
        avg[2] = intent.getDoubleExtra("thr1",0.0);
        avg[3] = intent.getDoubleExtra("fou1",0.0);
        avg[4] = intent.getDoubleExtra("fiv1",0.0);
        avg[5] = intent.getDoubleExtra("six1",0.0);
        avg[6] = intent.getDoubleExtra("sev1",0.0);
        avg[7] = intent.getDoubleExtra("eig1",0.0);
        avg[8] = intent.getDoubleExtra("nin1",0.0);
        avg[9] = intent.getDoubleExtra("ten1",0.0);
        avg[10] = intent.getDoubleExtra("ele1",0.0);

        stan[0] = intent.getDoubleExtra("one2",0.0);
        stan[1] = intent.getDoubleExtra("two2",0.0);
        stan[2] = intent.getDoubleExtra("thr2",0.0);
        stan[3] = intent.getDoubleExtra("fou2",0.0);
        stan[4] = intent.getDoubleExtra("fiv2",0.0);
        stan[5] = intent.getDoubleExtra("six2",0.0);
        stan[6] = intent.getDoubleExtra("sev2",0.0);
        stan[7] = intent.getDoubleExtra("eig2",0.0);
        stan[8] = intent.getDoubleExtra("nin2",0.0);
        stan[9] = intent.getDoubleExtra("ten2",0.0);
        stan[10] = intent.getDoubleExtra("ele2",0.0);



        scores[0]=guk; //점수를 배열에 저장
        scores[1]=doduk;
        scores[2]=sahwe;
        scores[3]=yuck;
        scores[4]=math;
        scores[5]=sci;
        scores[6]=giga;
        scores[7]=eng;
        scores[8]=one1;
        scores[9]=one2;
        scores[10]=one3;
//차트를 먼저 만든 이유: 처음부터 그래프가 나오게 하기 위해서
        LineData data;
        int j;
        int length;
        int k;
        LineDataSet set1;
        ArrayList<ILineDataSet> dataSets;
        ArrayList<Entry> yValues;
        YAxis leftAxis;
        XAxis xAxis;
        j=0;
        for(int i=0;i<11;i++){ //점수가 0인것을 다 추려냄
            if(scores[i]!=0){
                values[j]=xxx[i];
                j++;
            }
        }
        int lengths= j;

        chart=findViewById(R.id.chart);
        chart.getDescription().setEnabled(false);//설명 지우기
        chart.setDragEnabled(true);//드래그 허용
        chart.setScaleEnabled(false);
        chart.animateXY(1000,1000,Easing.EaseOutSine,Easing.EaseOutSine);

        chart.getAxisRight().setEnabled(false);//오른쪽 면 비우기


        yValues = new ArrayList<>();
        k=0;
        for(int i=0;i<=10;i++){//점수가 0이 아닌 과목만 추가하기
            if(scores[i]!=0) {
                yValues.add(new Entry(k, (float) scores[i]));
                k++;
            }
        }
        k=0;

        set1 = new LineDataSet(yValues,"성적");

        set1.setFillAlpha(110);

        set1.setColor(Color.RED);
        set1.setLineWidth(3f);
        set1.setCircleColor(Color.YELLOW);
        set1.setCircleRadius(5f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.BLACK);

        dataSets = new ArrayList<>();
        dataSets.add(set1);

        leftAxis = chart.getAxisLeft();
        YAxis rightAxis = chart.getAxisRight();

        //leftAxis.setSp
        leftAxis.setAxisMinimum(0f);//그래프의 점수 최소는 0
        leftAxis.setAxisMaximum(100f);//그래프의 점수 최대는 100
        leftAxis.setLabelCount(5);//라벨은 모두 5개 (차이는 각각 20점)
        //final String values[] = new String[] {"국어","도덕","사회","역사","수학","과학","기가","영어","선택","선택2","선택3"};
        xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        //xAxis.setCenterAxisLabels(true);
        xAxis.setLabelCount(3);
        chart.getXAxis().setLabelCount(lengths,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(values) {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return values[(int)value];
            }
        });
        data = new LineData(dataSets);
        chart.setData(data);

        chart.notifyDataSetChanged();
        chart.invalidate();

//라디오 버튼 만들기

        RadioButton radiogaga = findViewById(R.id.someone);
        RadioButton radiogugu = findViewById(R.id.stillloveyou);
        RadioGroup Queen = findViewById(R.id.radio);
        //.clearCheck();
        //radiogaga.setChecked(true);
        radiogaga.setChecked(true);//버튼이 선택되어있게 함

        Queen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                LineData data;//라인차트 기본은 만들어둠
                int j;
                int length;
                int k;
                LineDataSet set1;
                ArrayList<ILineDataSet> dataSets;
                ArrayList<Entry> yValues;
                YAxis leftAxis;
                XAxis xAxis;
                switch(checkedId){
                    case R.id.someone://원점수 버튼을 누른 경우
                        j=0;
                        for(int i=0;i<11;i++){ //점수가 0인 과목을 추려냄
                            if(scores[i]!=0){
                                values[j]=xxx[i];
                                j++;
                            }
                        }
                        int lengths= j;

                        chart=findViewById(R.id.chart);
                        chart.getDescription().setEnabled(false);
                        chart.setDragEnabled(true);
                        chart.setScaleEnabled(false);
                        chart.animateXY(1000,1000, Easing.EaseOutSine,Easing.EaseOutSine);

                        chart.getAxisRight().setEnabled(false);


                        yValues = new ArrayList<>();
                        k=0;
                        for(int i=0;i<=10;i++){//점수가 0인 과목을 제외한 과목을 차트에 추가함
                            if(scores[i]!=0) {
                                yValues.add(new Entry(k, (float) scores[i]));
                                k++;
                            }
                        }
                        k=0;

                        set1 = new LineDataSet(yValues,"성적");

                        set1.setFillAlpha(110);

                        set1.setColor(Color.RED);
                        set1.setLineWidth(3f);
                        set1.setCircleColor(Color.YELLOW);
                        set1.setCircleRadius(5f);
                        set1.setValueTextSize(10f);
                        set1.setValueTextColor(Color.BLACK);

                        dataSets = new ArrayList<>();
                        dataSets.add(set1);

                        leftAxis = chart.getAxisLeft();
                        YAxis rightAxis = chart.getAxisRight();

                        //leftAxis.setSp
                        leftAxis.setAxisMinimum(0f);
                        leftAxis.setAxisMaximum(100f);
                        leftAxis.setLabelCount(5);
                        //final String values[] = new String[] {"국어","도덕","사회","역사","수학","과학","기가","영어","선택","선택2","선택3"};
                        xAxis = chart.getXAxis();
                        xAxis.setDrawGridLines(false);
                        //xAxis.setCenterAxisLabels(true);
                        xAxis.setLabelCount(3);
                        chart.getXAxis().setLabelCount(lengths,true);
                        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(values) {
                            @Override
                            public String getFormattedValue(float value, AxisBase axis) {
                                return values[(int)value];
                            }
                        });
                        data = new LineData(dataSets);
                        chart.setData(data);

                        chart.notifyDataSetChanged();
                        chart.invalidate();
                        break;



                    case R.id.stillloveyou://표준점수 버튼을 누른 경우
                        double min=500000,max=-5000000;
                        j=0;
                        for(int i=0;i<11;i++){ //점수가 0인 과목을 추려냄
                            if(scores[i]!=0){
                                values[j]=xxx[i];
                                j++;
                            }
                        }
                        lengths= j;

                        chart=findViewById(R.id.chart);
                        chart.getDescription().setEnabled(false);
                        chart.setDragEnabled(true);
                        chart.setScaleEnabled(false);
                        chart.animateXY(1000,1000,Easing.EaseOutSine,Easing.EaseOutSine);//애니메이션 효과 추가

                        chart.getAxisRight().setEnabled(false);


                        yValues = new ArrayList<>();
                        k=0;
                        for(int i=0;i<=10;i++){
                            if(scores[i]!=0 && stan[i]!=0) {//최대값과 최소값 선별함
                                if((scores[i]-avg[i])/stan[i] < min) min=(scores[i]-avg[i])/stan[i];
                                if((scores[i]-avg[i])/stan[i] > max) max=(scores[i]-avg[i])/stan[i];
                                yValues.add(new Entry(k, (float)((scores[i]-avg[i])/stan[i])));
                                k++;
                            }
                        }
                        k=0;

                        set1 = new LineDataSet(yValues,"성적");

                        set1.setFillAlpha(110);

                        set1.setColor(Color.RED);
                        set1.setLineWidth(3f);
                        set1.setCircleColor(Color.YELLOW);
                        set1.setCircleRadius(5f);
                        set1.setValueTextSize(10f);
                        set1.setValueTextColor(Color.BLACK);

                        dataSets = new ArrayList<>();
                        dataSets.add(set1);

                        leftAxis = chart.getAxisLeft();


                        //leftAxis.setSp



                        //최댓값과 최솟값을 기준으로 표준점수 그래프를 만듦
                        leftAxis.setAxisMinimum((float)Math.floor(min));
                        leftAxis.setAxisMaximum((float)Math.ceil(max)); //여기를 수정
                        leftAxis.setLabelCount(10);





                        //final String values[] = new String[] {"국어","도덕","사회","역사","수학","과학","기가","영어","선택","선택2","선택3"};
                        xAxis = chart.getXAxis();
                        xAxis.setDrawGridLines(false);
                        //xAxis.setCenterAxisLabels(true);
                        xAxis.setLabelCount(3);
                        chart.getXAxis().setLabelCount(lengths,true);
                        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(values) {
                            @Override
                            public String getFormattedValue(float value, AxisBase axis) {
                                return values[(int)value];
                            }
                        });

                        data = new LineData(dataSets);
                        chart.setData(data);
                        chart.notifyDataSetChanged();
                        chart.invalidate();
                        break;

                }
            }
        });





        /*chart=findViewById(R.id.chart);

        chart.setDragEnabled(true);
        chart.setScaleEnabled(false);


        chart.getAxisRight().setEnabled(false);


        ArrayList<Entry> yValues = new ArrayList<>();
        int k=0;
        for(int i=0;i<=10;i++){
            if(scores[i]!=0) {
                yValues.add(new Entry(k, (float) scores[i]));
                k++;
            }
        }
        k=0;
        LineDataSet set1 = new LineDataSet(yValues,"성적");

        set1.setFillAlpha(110);

        set1.setColor(Color.RED);
        set1.setLineWidth(3f);
        set1.setCircleColor(Color.YELLOW);
        set1.setCircleRadius(5f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.BLACK);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        YAxis leftAxis = chart.getAxisLeft();
        YAxis rightAxis = chart.getAxisRight();

        //leftAxis.setSp
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisMaximum(100f);
        leftAxis.setLabelCount(5);
        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        //xAxis.setCenterAxisLabels(true);
        xAxis.setLabelCount(3);
        chart.getXAxis().setLabelCount(lengths,true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(values) {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return values[(int)value];
            }
        });*/


        /*XAxis xAxis = chart.getXAxis();
        xAxis.setLabelCount(20,true);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(100f);*/
        /*LineData data = new LineData(dataSets);
        chart.setData(data);*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //없으면 X버튼 증발
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.nagagi){
            Toast.makeText(this,"나가기", Toast.LENGTH_SHORT).show();
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            finish();
            return true;
        }
        else if(id==android.R.id.home){
            Toast.makeText(this,"나가기", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
