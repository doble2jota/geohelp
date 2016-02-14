package com.example.javier.geohelp.Activities.Adapters;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.geohelp.R;

/**
 * Created by javier on 13/02/2016.
 */
public class TabFragmentList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_list, container, false);
    }
}