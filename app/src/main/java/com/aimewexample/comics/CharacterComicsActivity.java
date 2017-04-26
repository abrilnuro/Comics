package com.aimewexample.comics;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.aimewexample.comics.adapters.CharacterListAdapter;
import com.aimewexample.comics.adapters.CharacterRecyclerAdapter;
import com.aimewexample.comics.databinding.ActivityCharacterComicsBinding;
import com.aimewexample.comics.events.SuccessGetCharacter;
import com.aimewexample.comics.models.Comics;
import com.aimewexample.comics.utils.App;
import com.aimewexample.comics.utils.Controller;
import com.squareup.otto.Subscribe;

public class CharacterComicsActivity extends AppCompatActivity implements CharacterRecyclerAdapter.OnRecyclerItemSelected{

    private ActivityCharacterComicsBinding binding;
    private CharacterRecyclerAdapter adapter;
    private LinearLayoutManager llm;
    private String character;
    private int search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_character_comics);
        App.getBus().register(this);

        //cachar intent
        character = getIntent().getStringExtra("character");
        search = getIntent().getIntExtra("search", 0);

        //hacer solicitud
        Controller controller = new Controller(this);
        controller.getCharacters(character);
    }


    @Subscribe
    public void onSuccessGetCharacter(SuccessGetCharacter successGetCharacter){
        //configurar listView
        llm = new LinearLayoutManager(this);
        binding.recyclerCharacter.setLayoutManager(llm);
        adapter = new CharacterRecyclerAdapter(this, successGetCharacter.getCharacterList());
        binding.recyclerCharacter.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(int position) {
        if(search == 1) {
            Intent intent = new Intent(CharacterComicsActivity.this, CharacterDetailsActivity.class);
            intent.putExtra("position", position);
            intent.putExtra("character", character);
            startActivity(intent);
        }else{
            Intent intent = new Intent(CharacterComicsActivity.this, ComicsActivity.class);
            intent.putExtra("position", position);
            intent.putExtra("character", character);
            startActivity(intent);
        }
    }
}
