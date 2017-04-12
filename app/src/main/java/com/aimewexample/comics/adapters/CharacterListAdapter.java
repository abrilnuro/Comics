package com.aimewexample.comics.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aimewexample.comics.R;
import com.aimewexample.comics.models.Characters;

import java.util.List;
import java.util.Random;

/**
 * Created by aimew on 06/04/2017.
 */

public class CharacterListAdapter extends ArrayAdapter<Characters>{

    private List<Characters> characterList;

    public CharacterListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Characters> objects) {
        super(context, resource, objects);
        characterList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //inflar view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);

        //refernciar elementos
        TextView textItemComic = (TextView) view.findViewById(R.id.text_item_character);
        //CardView cardItemComic = (CardView) view.findViewById(R.id.card_item_comic);

        //mostrar datos
        textItemComic.setText(characterList.get(position).getName());
        //cardItemComic.setBackgroundColor(Color.parseColor("#FF4081"));

        return view;
    }

    public String itemColor() {
        String[] colors = new String[]{"#ff33b5e5", "#FF4081", "#680102"};
        Random r = new Random(0-2);
        String color = colors[2];
        return color;
    }
}
