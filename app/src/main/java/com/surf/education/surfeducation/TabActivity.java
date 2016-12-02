package com.surf.education.surfeducation;

import android.support.v4.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabActivity extends AppCompatActivity {
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity);

        BlockFragment fragment = new BlockFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.block_fragment, fragment)
                //.add(R.id.block_fragment2, fragment)
                .commit();

        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new PagerAdapter(fragmentManager);
        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //сработает, при изменении положения страницы
                //возвращает положение текущей страницы при прокрутке
            }

            @Override
            public void onPageSelected(int position) {
                //срабатывает при смене страницы
                //возвращает позицию отображаемой страницы
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //срабатывает при смене состояния скроллера
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);

    }
}
