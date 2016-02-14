package com.example.javier.geohelp.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.javier.geohelp.Activities.Adapters.PageAdapterHelpSomeone;
import com.example.javier.geohelp.Activities.Presenters.HelpSomeonePresenter;
import com.example.javier.geohelp.Activities.Presenters.HelpSomeonePresenterImpl;
import com.example.javier.geohelp.R;

/**
 * Created by javier on 13/02/2016.
 */
public class HelpSomeoneActivity extends AbstractActivity<HelpSomeonePresenter> implements HelpSomeoneView{

    private TabLayout tabLayout;

    HelpSomeoneView helpSomeoneView;
    private HelpSomeonePresenterImpl helpSomeonePresenter;

    @Override
    protected HelpSomeonePresenter createPresenter() {
        this.helpSomeonePresenter = new HelpSomeonePresenterImpl(this);
        return this.helpSomeonePresenter;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_someone_layout);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout_help_someone);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.title_tab_list)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.title_tab_map)));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final PageAdapterHelpSomeone adapter = new PageAdapterHelpSomeone
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
