package com.example.javier.geohelp.Activities.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.Activities.HelpSomeoneActivity;
import com.example.javier.geohelp.Activities.HelpSomeoneView;
import com.example.javier.geohelp.Activities.Presenters.HelpSomeonePresenterImpl;
import com.example.javier.geohelp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javier on 13/02/2016.
 */
public class TabFragmentList extends Fragment implements SwipeRefreshLayout.OnRefreshListener,HelpSomeoneView {

    private HelpEntity helpEntity=new HelpEntity();
    private HelpListAdapter adapter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private SwipeRefreshLayout swipeLayout;
    private HelpSomeonePresenterImpl helpSomeonePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_list, container, false);

       // helpSomeonePresenter= new HelpSomeonePresenterImpl(this);

        List<HelpEntity> listHelp= new ArrayList<HelpEntity>();
        HelpEntity helpEntity= new HelpEntity();
        helpEntity.setName("prueba1");
        helpEntity.setCategory("categoria 1");
        helpEntity.setIdImage(R.drawable.ic_profile);
        listHelp.add(helpEntity);

        recycler = (RecyclerView) rootView.findViewById(R.id.recycler);
        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);
        helpSomeonePresenter = ((HelpSomeoneActivity) getActivity()).getPresenter();
        helpSomeonePresenter.setView(this);


        lManager = new LinearLayoutManager(this.getActivity());
        recycler.setLayoutManager(lManager);

        adapter = new HelpListAdapter(listHelp);
        recycler.setAdapter(adapter);

        swipeLayout.setOnRefreshListener(this);

        return rootView;
    }

    @Override
    public void onRefresh() {
        helpSomeonePresenter.refreshItems();
    }


    @Override
    public HelpSomeonePresenterImpl getPresenter() {return null;

    }

    @Override
    public void getListEvent(List<HelpEntity> helpEntityList) {

        helpEntity.setHelp(helpEntityList);
        adapter.clear();
        // Añadir elementos nuevos
        adapter.addAll(helpEntityList);
        // Parar la animación del indicador
        swipeLayout.setRefreshing(false);
    }
}