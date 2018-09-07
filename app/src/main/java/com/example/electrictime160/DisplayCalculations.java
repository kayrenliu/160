package com.example.electrictime160;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class DisplayCalculations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_calculations);
        // Mapping transport types to MPH
        Map<String, Double> map = new HashMap<>();
        map.put("Walking", 3.1);
        map.put("Boosted Mini S Board", 18.);
        map.put("Evolve Skateboard", 26.);
        map.put("Segway i2 SE", 12.5);
        map.put("Hovertrax Hoverboard", 8.);

        // Get the Intent that started this activity and calculate
        Intent intent = getIntent();
        String from = intent.getStringExtra(MainActivity.FROM_VALUE);
        String to = intent.getStringExtra(MainActivity.TO_VALUE);
        double milesInput = Double.parseDouble(intent.getStringExtra(MainActivity.MILEAGE));

        double MPH = map.get(from);
        double value = milesInput / MPH;
        String result = String.format("It will take you %.2f hours to reach your destination using the %s", value, from);
        TextView textView1 = findViewById(R.id.textView4);
        textView1.setText(result);

        String toResult = "";
        if (!to.equals("None")) {
            MPH = map.get(to);
            value = milesInput / MPH;
            toResult = String.format("It will take you %.2f hours to reach your destination using the %s", value, to);
        }
        TextView textView2 = findViewById(R.id.textView5);
        textView2.setText(toResult);
    }
}
