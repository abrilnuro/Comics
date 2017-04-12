package com.aimewexample.comics;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aimewexample.comics.adapters.CharacterListAdapter;
import com.aimewexample.comics.adapters.ComicListAdapter;
import com.aimewexample.comics.adapters.ComicRecyclerAdapter;
import com.aimewexample.comics.databinding.ActivityComicsBinding;
import com.aimewexample.comics.events.SuccessGetComics;
import com.aimewexample.comics.utils.App;
import com.aimewexample.comics.utils.Controller;
import com.squareup.otto.Subscribe;

public class ComicsActivity extends AppCompatActivity {

    private ActivityComicsBinding binding;
    private ComicRecyclerAdapter adapter;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comics);
        App.getBus().register(this);

        //cachar el intent
        int characterPosition = getIntent().getIntExtra("position", 0);
        String character = getIntent().getStringExtra("character");

        //hacer solicitud
        Controller controller = new Controller(this);
        controller.getComics(character, characterPosition);
    }

    @Subscribe
    public void onSuccessGetComics(SuccessGetComics successGetComics){
        if(successGetComics.getComicsList().size() == 0){
            binding.textCharacterComics.setVisibility(View.VISIBLE);
        }else {
            //configurar listView
            llm = new LinearLayoutManager(this);
            binding.recyclerComic.setLayoutManager(llm);
            adapter = new ComicRecyclerAdapter(successGetComics.getComicsList());
            binding.recyclerComic.setAdapter(adapter);
        }
    }
}
