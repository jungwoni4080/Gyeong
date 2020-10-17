package org.techtown.gyeongcopy;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class MyPagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs; //탭의 갯수

    public MyPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.mNumOfTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) { //탭을 자유롭게 이동할 수 있게 함
        switch (position){
            case 0:
                Fragment_0 tab0 = new Fragment_0();
                return tab0;
            case 1:
                Fragment_inf tabi = new Fragment_inf();
                return tabi;
            case 2 :
                Fragment_1 tab1 = new Fragment_1();
                return tab1;
            case 3:
                Fragment_2 tab2 = new Fragment_2();
                return tab2;
            case 4:
                Fragment_3 tab3 = new Fragment_3();
                return tab3;
            case 5:
                Fragment_4 tab4 = new Fragment_4();
                return tab4;
            case 6:
                Fragment_5 tab5 = new Fragment_5();
                return tab5;
            default:
                return null;
        }
        //return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}