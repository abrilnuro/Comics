package com.aimewexample.comics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aimewexample.comics.adapters.CharacterRecyclerAdapter;
import com.aimewexample.comics.utils.Controller;

public class CharacterDetailsActivity extends AppCompatActivity {

    private ImageView imageCharacter;
    private TextView textName;
    private TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);

        //referenciar elementos
        imageCharacter = (ImageView) findViewById(R.id.image_character);
        textName = (TextView)findViewById(R.id.text_name);
        textDescription = (TextView)findViewById(R.id.text_description);

        //cachar intent
        String character = getIntent().getStringExtra("character");
        int position = getIntent().getIntExtra("position", 0);

        //hacer solicitud
        Controller controller = new Controller(this);
        controller.getDetails(character, position);
    }


}
