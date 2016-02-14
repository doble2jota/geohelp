package com.example.javier.geohelp.Activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.javier.geohelp.Activities.Components.GeoHelpEditText;
import com.example.javier.geohelp.Activities.Entities.HelpTypeEntity;
import com.example.javier.geohelp.Activities.Presenters.NeedHelpPresenter;
import com.example.javier.geohelp.Activities.Presenters.NeedHelpPresenterImpl;
import com.example.javier.geohelp.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by raquel on 13/02/2016.
 */
public class NeedHelpActivity extends AbstractActivity<NeedHelpPresenter> implements NeedHelpView, View.OnClickListener {

    private NeedHelpView needHelpView;
    private NeedHelpPresenterImpl needHelpPresenter;

    private RelativeLayout parentNeedHelp;
    private EditText nameEditText,descriptionEditText;
    private Spinner spinnerTypeHelp;
    private List<HelpTypeEntity> helpTypeEntityList;
    private Button btnCreateHelp;

    @Override
    protected NeedHelpPresenter createPresenter() {
        this.needHelpPresenter = new NeedHelpPresenterImpl(this);
        return needHelpPresenter;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_me_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.setTextToolbar(R.string.title_home, R.color.GeoHelp_primary);

        parentNeedHelp = (RelativeLayout) findViewById(R.id.parent_need_help_form);
        nameEditText = (EditText) findViewById(R.id.editext_name_help);
        descriptionEditText = (EditText) findViewById(R.id.editext_description_help);
        spinnerTypeHelp = (Spinner) findViewById(R.id.spinner_type_help);
        helpTypeEntityList = new ArrayList<>();
        needHelpPresenter.getHelpTypeEntityList();

        btnCreateHelp = (Button) findViewById(R.id.button_create_help);
        btnCreateHelp.setOnClickListener(this);

    }

    @Override
    public void startActivy() {

    }

    @Override
    public void finishActivy() {

    }

    @Override
    public void setHelpTypes(List<HelpTypeEntity> helpTypeEntityList) {
        this.helpTypeEntityList = helpTypeEntityList;

    }

    @Override
    public void populateHepTypesSpinner() {
        ArrayAdapter<HelpTypeEntity> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, helpTypeEntityList);
        spinnerTypeHelp.setAdapter(myAdapter);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_create_help) {
            String name = nameEditText.getText().toString();
            String description = descriptionEditText.getText().toString();
            String tipo = spinnerTypeHelp.getSelectedItem().toString();
            String latString = "0";
            String longString = "0";
            needHelpPresenter.createHelp(name,description,tipo,latString,longString);

        }
    }
}
