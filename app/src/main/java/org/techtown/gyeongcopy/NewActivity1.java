package org.techtown.gyeongcopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewActivity1 extends AppCompatActivity {
    double scores[] = new double[11];
    //String values[] = new String[11] {"국어","도덕","사회","역사","수학","과학","기가","영어","선택","선택2","선택3"};
    String xxx[] = new String[] {"국어","도덕","사회","역사","수학","과학","기가","영어","선택","선택2","선택3"};
    double avg[] = new double[11];
    double stan[] = new double[11];
    String values[] = new String[11];
    double guk,doduk,sahwe,yuck,math,sci,giga,eng,one1,one2,one3;
    int k=0,lengths=0;
    TextView textView,textView1;
    int l=0;
    LineChart chart;
    //
    //ArrayList<Entry> yValues = new ArrayList<>();
    //LineDataSet set1 = new LineDataSet(yValues,"성적");
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);
        getSupportActionBar().setTitle("2-1 그래프");
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






        scores[0]=guk; //0판별은다 됨
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



        /*int j=0;  //과목의 개수 측정
        for(int i=0;i<11;i++){ //xxx에서 values로 옮기는건 다 잘 됨
            if(scores[i]!=0 && stan[i]!=0){
                values[j]=xxx[i];
                j++;
            }
        }
        lengths= j;
        j=0;*/


//ㅁㄻㅇㄹㅇㅁㄹㅇㄻㄴㅇㄹ
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
        for(int i=0;i<11;i++){ //xxx에서 values로 옮기는건 다 잘 됨
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
        chart.animateXY(1000,1000,Easing.EaseOutSine,Easing.EaseOutSine);

        chart.getAxisRight().setEnabled(false);


        yValues = new ArrayList<>();
        k=0;
        for(int i=0;i<=10;i++){
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

//ㅇㄴㅁㄹㅇㅁㄴㄹㅇㅁㄴㄹㅇㅁㄴ

        RadioButton radiogaga = findViewById(R.id.someone);
        RadioButton radiogugu = findViewById(R.id.stillloveyou);
        RadioGroup Queen = findViewById(R.id.radio);
        //.clearCheck();
        //radiogaga.setChecked(true);
        radiogaga.setChecked(true);

        Queen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                LineData data;
                int j;
                int length;
                int k;
                LineDataSet set1;
                ArrayList<ILineDataSet> dataSets;
                ArrayList<Entry> yValues;
                YAxis leftAxis;
                XAxis xAxis;
                switch(checkedId){
                    case R.id.someone:
                        j=0;
                        for(int i=0;i<11;i++){ //xxx에서 values로 옮기는건 다 잘 됨
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
                        chart.animateXY(1000,1000,Easing.EaseOutSine,Easing.EaseOutSine);

                        chart.getAxisRight().setEnabled(false);


                        yValues = new ArrayList<>();
                        k=0;
                        for(int i=0;i<=10;i++){
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



                    case R.id.stillloveyou:
                        double min=500000,max=-5000000;
                        j=0;
                        for(int i=0;i<11;i++){ //xxx에서 values로 옮기는건 다 잘 됨
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
                        chart.animateXY(1000,1000,Easing.EaseOutSine,Easing.EaseOutSine);

                        chart.getAxisRight().setEnabled(false);


                        yValues = new ArrayList<>();
                        k=0;
                        for(int i=0;i<=10;i++){
                            if(scores[i]!=0 && stan[i]!=0) {
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
