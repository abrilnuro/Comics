package com.aimewexample.comics.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aimewexample.comics.R;
import com.aimewexample.comics.models.Characters;
import com.aimewexample.comics.models.Comics;

import java.util.List;

/**
 * Created by aimew on 12/04/2017.
 */

public class ComicListAdapter extends ArrayAdapter<Comics> {

    private List<Comics> comicList;

    public ComicListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Comics> objects) {
        super(context, resource, objects);
        comicList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //inflar view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);

        //refernciar elementos
        TextView textItemComic = (TextView) view.findViewById(R.id.text_item_comic);
        //CardView cardItemComic = (CardView) view.findViewById(R.id.card_item_comic);

        //mostrar datos
        textItemComic.setText(comicList.get(position).getName());
        //cardItemComic.setBackgroundColor(Color.parseColor("#FF4081"));

        return view;
    }
}
