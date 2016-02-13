package com.example.javier.geohelp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.javier.geohelp.Activities.Presenters.SettingPresenter;
import com.example.javier.geohelp.Activities.Presenters.SettingsPresenterImpl;
import com.example.javier.geohelp.R;

/**
 * Created by javier on 06/02/2016.
 */
public class SettingsActivity extends AbstractActivity<SettingPresenter> implements SettingsView,View.OnClickListener{

    RelativeLayout layoutLogout;
    private SettingsPresenterImpl settingsPresenter;


    @Override
    protected SettingPresenter createPresenter() {
        this.settingsPresenter = new SettingsPresenterImpl(this);
        return this.settingsPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        layoutLogout= (RelativeLayout)findViewById(R.id.layout_logout);
        layoutLogout.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.setTextToolbar(R.string.title_settings, R.color.background_floating_material_dark);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_logout:
                settingsPresenter.logoutUser();
                break;
            default:
                break;
        }
    }

    private void goToActivity(Class<?> className) {
        Intent intent = new Intent(this, className);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void logoutUser() {
        goToActivity(LoginActivity.class);
    }

    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onResume(){
        super.onResume();
    }

}
