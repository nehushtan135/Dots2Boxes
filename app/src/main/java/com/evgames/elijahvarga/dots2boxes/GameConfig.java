package com.evgames.elijahvarga.dots2boxes;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class GameConfig extends AppCompatActivity {


    Button startGame;
    Spinner spinner1;
    Spinner spinner2;
    EditText p1;
    EditText p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_config);
        //initialize parts
        startGame= (Button) findViewById(R.id.beginButton);
        spinner1 = (Spinner) findViewById(R.id.p1Color);
        spinner2 = (Spinner) findViewById(R.id.p2Color);
        p1 = (EditText) findViewById(R.id.p1Input);
        p2 = (EditText) findViewById(R.id.p2Input);


        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(),ActualGame.class);
                //TODO: Get player inputed data and send it to game activity through Intent.
                if(p1.getText().toString().equals(p2.getText().toString())){
                    Snackbar.make(v,"Player names must be different!",Snackbar.LENGTH_LONG )
                    .setAction("Action",null).show();
                }
                else {
                    startActivity(it);
                }
            }
        });


    }
}
