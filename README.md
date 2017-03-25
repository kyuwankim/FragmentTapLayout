# Fragment Pager & Tab Layout
프래그먼트 페이저와 탭레이아웃을 연동합니다

## Fragment Pager
프래그먼트 페이저 사용시 버전호환성을 위해 Support 계열의 Api를 사용합니다.

```java
// 1. 뷰페이저 위젯 가져오기
ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
// 2. 아답터 생성
PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
// 3. 아답터 등록
viewPager.setAdapter(adapter);


// 프래그먼트 페이저 Adapter
class PagerAdapter extends FragmentStatePagerAdapter {
    // Fragment 페이저 생성자 - 인자로 Fragment Manager를 넘겨야 한다.
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // ListView 의 getView 와 같은 역할 - 각 position에 맞는 fragment 를 return해야한다.
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0: fragment = one; break;
            case 1: fragment = two; break;
            case 2: fragment = three; break;
            case 3: fragment = four; break;
        }
        return fragment;
    }

    // fragment 화면 개수
    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
```

## Tab Layout
```java
// 탭 Layout 정의
TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
// 탭 생성 및 타이틀 입력 - 동적으로 생성해 줄 수 있다
tabLayout.addTab( tabLayout.newTab().setText("계산기") );
tabLayout.addTab( tabLayout.newTab().setText("단위변환") );
tabLayout.addTab( tabLayout.newTab().setText("검색") );
tabLayout.addTab( tabLayout.newTab().setText("현재위치") );
```

## Change Listener
```java
// 1. 페이저 리스너 : 페이저가 변경되었을때 탭을 바꿔주는 리스너
viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

// 2. 탭 리스너 : 탭이 변경되었을 때 페이지를 바꿔주는 리스너
tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
```