package com.example.javier.geohelp.Activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.Presenters.HelpSomeonePresenterImpl;
import com.example.javier.geohelp.Activities.Presenters.NeedHelpPresenter;
import com.example.javier.geohelp.Activities.Presenters.NeedHelpPresenterImpl;
import com.example.javier.geohelp.Activities.Utils.GeoHelpConstans;
import com.example.javier.geohelp.R;
import com.firebase.client.Firebase;

/**
 * Created by raquel on 13/02/2016.
 */
public class NeedHelpActivity extends AbstractActivity<NeedHelpPresenter> implements NeedHelpView {

    NeedHelpView helpSomeoneView;
    private NeedHelpView needHelpView;
    private NeedHelpPresenterImpl needHelpPresenter;

    protected NeedHelpPresenter createPresenter() {
        this.needHelpPresenter = new NeedHelpPresenterImpl();
        return needHelpPresenter;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_me_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.setTextToolbar(R.string.title_home, R.color.GeoHelp_primary);


    }

    @Override
    public void startActivy() {

    }

    @Override
    public void finishActivy() {

    }
}
