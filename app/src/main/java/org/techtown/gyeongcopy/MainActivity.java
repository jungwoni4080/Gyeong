package org.techtown.gyeongcopy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import org.techtown.gyeongcopy.R;

//수정
public class MainActivity extends AppCompatActivity {

    double twoone=0;
    double twotwo=0;
    double throne=0;
    double thrtwo=0;
    double artpe=0;
    double artpe1=0;
    double artpe2=0;
    double artpe3=0;
    double artpe4=0;
    double sangchul;
    double sangbong;
    double sanghak;
    double sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this,NewActivity0.class);
        intent.putExtra("one",twoone);
        intent.putExtra("one2",twotwo);
        intent.putExtra("one3",throne);
        intent.putExtra("one4",thrtwo);
        //Tablayout
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("결과"));
        tabs.addTab(tabs.newTab().setText("정보"));
        tabs.addTab(tabs.newTab().setText("2-1"));
        tabs.addTab(tabs.newTab().setText("2-2"));
        tabs.addTab(tabs.newTab().setText("3-1"));
        tabs.addTab(tabs.newTab().setText("3-2"));
        tabs.addTab(tabs.newTab().setText("생기부"));
        tabs.setTabGravity(tabs.GRAVITY_FILL);


        //Adapter
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        final MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), 7);
        viewPager.setAdapter(myPagerAdapter);

        //탭 선택 이벤트
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
    }
}
