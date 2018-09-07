package com.example.electrictime160;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static final String FROM_VALUE = "FROMVALUE";
    public static final String TO_VALUE = "TOVALUE";
    public static final String MILEAGE = "MILES";

    final String[] toSelectedItem = new String[1];
    final String[] fromSelectedItem = new String[1];

    Spinner fromSpinner;
    Spinner toSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpinner = findViewById(R.id.spinner);
        toSpinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this,
                R.array.typesOfTransport, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromAdapter);

        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this,
                R.array.typesOfTransport2, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toAdapter);

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromSelectedItem[0] = parent.getItemAtPosition(position).toString(); //this is your selected it
            }

            public void onNothingSelected(AdapterView<?> parent) { }
        });
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toSelectedItem[0] = parent.getItemAtPosition(position).toString(); //this is your selected item
            }

            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    public void calculate(View view) {
        Intent intent = new Intent(this, DisplayCalculations.class);
        EditText editText = findViewById(R.id.editText3);
        String mileage = editText.getText().toString();

        // System.out.println(fromSelectedItem[0]);
        intent.putExtra(FROM_VALUE, fromSelectedItem[0]);
        intent.putExtra(TO_VALUE, toSelectedItem[0]);
        intent.putExtra(MILEAGE, mileage);
        startActivity(intent);
    }



}
