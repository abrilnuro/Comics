package com.aimewexample.comics.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aimewexample.comics.R;
import com.aimewexample.comics.models.Characters;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.List;

/**
 * Created by aimew on 12/04/2017.
 */

public class CharacterRecyclerAdapter extends RecyclerView.Adapter<CharacterRecyclerAdapter.CharacterViewHolder> {

    private List<Characters> characterList;
    private Context context;
    private OnRecyclerItemSelected listener;

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        CharacterViewHolder cvh = new CharacterViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, final int position) {
        holder.textItemCharacter.setText(characterList.get(position).getName());
        holder.viewItemCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemSelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public CharacterRecyclerAdapter(Context context, List<Characters> characterList) {
        this.characterList = characterList;
        this.context = context;
        listener = (OnRecyclerItemSelected) context;
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder{

        TextView textItemCharacter;
        View viewItemCharacter;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            textItemCharacter = (TextView) itemView.findViewById(R.id.text_item_character);
            viewItemCharacter = (View)itemView.findViewById(R.id.view_item_character);
        }
    }

    public interface OnRecyclerItemSelected{
        public void onItemSelected(int position);
    }

}

