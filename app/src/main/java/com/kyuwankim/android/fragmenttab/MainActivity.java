package com.kyuwankim.android.fragmenttab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 탭 및 페이저 속성 정의
    final int TAB_COUNT = 4;
    OneFragment one;
    TwoFragment two;
    ThreeFragment three;
    FourFragment four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트 초기화
        one = new OneFragment();
        two = new TwoFragment();
        three = new ThreeFragment();
        four = new FourFragment();

        //탭레이아웃 정의
        TabLayout tablayout = (TabLayout) findViewById(R.id.tab);
        tablayout.addTab(tablayout.newTab().setText("Calculator"));
        tablayout.addTab(tablayout.newTab().setText("단위변환"));
        tablayout.addTab(tablayout.newTab().setText("Search"));
        tablayout.addTab(tablayout.newTab().setText("Location"));

        //프레그먼트 페이저 작성
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);

        //어댑터 생성
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);

        //1. 페이저 리스너 : 페이저가 변경되었을때 탭을 바꿔주는 리스너
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        //2. 탭이 변경되었을때 페이지를 바꾸어주는 리스너
        tablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager));
    }

    class PagerAdapter extends FragmentStatePagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch(position) {
                case 0 : fragment = one; break;
                case 1 : fragment = two; break;
                case 2 : fragment = three; break;
                case 3 : fragment = four; break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }
}
