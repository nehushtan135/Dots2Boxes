package com.evgames.elijahvarga.dots2boxes;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameConfig extends AppCompatActivity {


    Button startGame;
    Spinner spinner1;
   // SpinnerAdapter sa1;
    Spinner spinner2;
    //SpinnerAdapter sa2;
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

        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Select Color");
        spinnerArray.add("Red");
        spinnerArray.add("Green");
        spinnerArray.add("Blue");
        spinnerArray.add("Yellow");
        spinnerArray.add("Pink");
        spinnerArray.add("Cyan");
        spinnerArray.add("Purple");
        spinnerArray.add("Black");



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View v = null;

                // If this is the initial dummy entry, make it hidden
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                }
                else {
                    // Pass convertView as null to prevent reuse of special case views
                    v = super.getDropDownView(position, null, parent);
                }

                // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                parent.setVerticalScrollBarEnabled(false);
                return v;
            }
        };

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);


        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean passActivity = true;
                Intent it = new Intent(getBaseContext(),ActualGame.class);
                //TODO: Get player inputed data and send it to game activity through Intent.
                if(p1.getText().toString().equals(p2.getText().toString())){
                    Snackbar.make(v,"Player names must be different!",Snackbar.LENGTH_LONG )
                    .setAction("Action",null).show();
                    passActivity = false;
                }
                else {
                    it.putExtra("P1_Name",p1.getText().toString());
                    it.putExtra("P2_Name",p2.getText().toString());
                }

                if(passActivity){
                    startActivity(it);
                }
            }
        });


    }
}
