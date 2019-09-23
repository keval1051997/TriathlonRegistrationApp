package com.example.triathlonregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerTeam = 725;
    int numberOfAthletesOnTeam;
    double totalCost;
    String LocationChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText teams = (EditText)findViewById(R.id.txtTeam);
        final Spinner group = (Spinner)findViewById(R.id.txtLocation);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {
                numberOfAthletesOnTeam = Integer.parseInt(teams.getText( ).toString( ));
                totalCost = costPerTeam * numberOfAthletesOnTeam;
                DecimalFormat currency = new DecimalFormat("$###,###");
                LocationChoice = group.getSelectedItem( ).toString( );
                result.setText(LocationChoice + " race team fee is " + currency.format(totalCost));
            }
        });
    }
}
