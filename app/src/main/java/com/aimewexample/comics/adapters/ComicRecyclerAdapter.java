package com.aimewexample.comics.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aimewexample.comics.R;
import com.aimewexample.comics.models.Comics;

import java.util.List;

/**
 * Created by aimew on 12/04/2017.
 */

public class ComicRecyclerAdapter extends RecyclerView.Adapter<ComicRecyclerAdapter.ComicViewHolder> {

    private List<Comics> comicsList;

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);
        ComicViewHolder cvh = new ComicViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        holder.textItemComic.setText(comicsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }

    public ComicRecyclerAdapter(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder{

        TextView textItemComic;

        public ComicViewHolder(View itemView) {
            super(itemView);
            textItemComic = (TextView) itemView.findViewById(R.id.text_item_comic);
        }
    }
}
