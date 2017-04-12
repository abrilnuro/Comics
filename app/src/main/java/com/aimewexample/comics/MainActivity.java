package com.aimewexample.comics;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aimewexample.comics.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding binding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //asignar escuchadores a los botones
        binding.buttonCharacter.setOnClickListener(this);
        binding.buttonComic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_character:
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("search", 1);
                startActivity(intent);
                break;
            case R.id.button_comic:
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("search", 2);
                startActivity(intent);
                break;
        }
    }
}
