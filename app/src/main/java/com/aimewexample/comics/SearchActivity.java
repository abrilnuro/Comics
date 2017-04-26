package com.aimewexample.comics;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aimewexample.comics.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySearchBinding binding;
    private int search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        //cachar el intent
        search = getIntent().getIntExtra("search", 0);

        //asginar el escuchador al boton
        binding.buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()) {
           case R.id.button_search:
               String character = binding.editSearch.getText().toString();

               //validar que no esté vacio el edittext
               if(character.isEmpty()) {
                   binding.editSearch.setError("Ingresa un personaje");
                   binding.editSearch.requestFocus();
               } else{
                   Intent intent = new Intent(SearchActivity.this, CharacterComicsActivity.class);
                   intent.putExtra("character", character);
                   intent.putExtra("search", search);
                   startActivity(intent);
                   /*if (search == 1) {
                       intent = new Intent(SearchActivity.this, CharacterDetailsActivity.class);
                       intent.putExtra("character", character);
                       startActivity(intent);
                   } else {
                       intent = new Intent(SearchActivity.this, CharacterComicsActivity.class);
                       intent.putExtra("character", character);
                       startActivity(intent);
                   }*/
               }
               break;
       }
    }
}
