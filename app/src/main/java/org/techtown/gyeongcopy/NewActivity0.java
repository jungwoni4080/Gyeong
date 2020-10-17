package org.techtown.gyeongcopy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Map;

public class NewActivity0 extends AppCompatActivity /*implements View.OnClickListener*/ {
    //Toolbar mytoolbar;
    double one,two,thr,fou;
    TextView textview;
    RadarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new0);
        getSupportActionBar().setTitle("결과");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //mytoolbar=(Toolbar)findViewById(R.id.my_toolbar);
        //  setSupportActionBar(mytoolbar);

        Intent intent = getIntent();
        one = intent.getDoubleExtra("one",0.0); //2-1학기 창에서 넘긴 점수를 받는다
        two= intent.getDoubleExtra("two",0.0);
        thr = intent.getDoubleExtra("thr",0.0);
        fou = intent.getDoubleExtra("fou",0.0);
        /*one = intent.getExtras().getDouble("one");
        two = intent.getExtras().getDouble("one2");
        thr = intent.getExtras().getDouble("one3");
        fou = intent.getExtras().getDouble("one4");*/
        /*Bundle intent = getIntent().getExtras();
        if(intent!=null){
            one = intent.getDouble("First");
            two = intent.getDouble("Second");
            thr = intent.getDouble("Third");
            fou = intent.getDouble("Fourth");
        }*/

        chart = findViewById(R.id.chart);
        chart=findViewById(R.id.chart);
        chart.setBackgroundColor(Color.rgb(255,255,255));
        chart.getDescription().setEnabled(false);
        //chart.setWebColor(Color.BLUE); 난해함
        chart.setWebLineWidth(1f);
        /*chart.setWebColor(Color.WHITE);
        chart.setWebLineWidth(1f);
        chart.setWebColorInner(Color.WHITE);
        chart.setWebAlpha(100);*/


        RadarDataSet dataSet1 = new RadarDataSet(dataValues1(),"학기별 성적"); //차트의 종류는 레이더 차트
        dataSet1.setColor(Color.RED);

        RadarData data = new RadarData();
        data.addDataSet(dataSet1);

        String[] labels = {"2-1성적", "2-2성적","3-1성적", "3-2성적"}; //각 요소의 이름
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        YAxis yAxis = chart.getYAxis();
        yAxis.setLabelCount(6,true);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(30f);

        chart.setData(data);





        /*LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //없으면 X버튼 증발
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //2개의 나가기 버튼 구현
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

    private ArrayList<RadarEntry> dataValues1()
    {
        ArrayList<RadarEntry> dataVals = new ArrayList<RadarEntry>(); //그래프에 넣을 값 지정
        dataVals.add(new RadarEntry((float)one));
        dataVals.add(new RadarEntry((float)two));
        dataVals.add(new RadarEntry((float)thr));
        dataVals.add(new RadarEntry((float)fou));

        return dataVals;
    }


    /*
    @Override
    public void onClick(View v) {

    }*/
}
