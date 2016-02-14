package com.example.javier.geohelp.Activities.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.geohelp.Activities.Entities.HelpEntity;
import com.example.javier.geohelp.R;

import java.util.List;

/**
 * Created by javier on 14/02/2016.
 */

public class HelpListAdapter extends RecyclerView.Adapter<HelpListAdapter.HelpViewHolder> {

    private List<HelpEntity> help;

    public static class HelpViewHolder extends RecyclerView.ViewHolder {
        // Campos de la lista
        public ImageView userImage;
        public TextView title;
        public TextView category;

        public HelpViewHolder(View v) {
            super(v);
            userImage = (ImageView) v.findViewById(R.id.user_image);
            title = (TextView) v.findViewById(R.id.title_help);
            category = (TextView) v.findViewById(R.id.category);
        }
    }

    public HelpListAdapter(List<HelpEntity> help) {
        this.help = help;
    }

    /*
    Añade una lista completa de items
     */
    public void addAll(List<HelpEntity> lista){
        help.addAll(lista);
        notifyDataSetChanged();
    }

    /*
    Permite limpiar todos los elementos del recycler
     */
    public void clear(){
        help.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return help.size();
    }

    @Override
    public HelpViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.help_celd_items_layout, viewGroup, false);
        return new HelpViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HelpViewHolder viewHolder, int i) {
        viewHolder.userImage.setImageResource(help.get(i).getIdImagen());
        viewHolder.title.setText(help.get(i).getNombre());
        viewHolder.category.setText("Votos: "+String.valueOf(help.get(i).getCategory()));
    }
}