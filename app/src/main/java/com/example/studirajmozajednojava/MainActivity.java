package com.example.studirajmozajednojava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Activity activity = this;
        Window window = activity.getWindow();

//// clear FLAG_TRANSLUCENT_STATUS flag:
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//
//// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//
//// finally change the color
//        window.setStatusBarColor(ContextCompat.getColor(activity, com.google.android.material.R.color.material_dynamic_primary80));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Spinner spinner = (Spinner) findViewById(R.id.smijer_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.smijerovi_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText et = (EditText) findViewById(R.id.prosjekInput);
        et.setFilters(new InputFilter[]{ new numberInputMinMax("1", "5")});
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button next = (Button)findViewById(R.id.next1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_activity = new Intent(MainActivity.this,
                        //MainActivityFakultetiPrikaz.class);
                        //TestActivityKotlin.class);
                        MainMeatActivity.class);
                CharSequence smijer = spinner.getPrompt();
                double prosijek;
                String prosijek_text = et.getText().toString();
                if (prosijek_text.equals("")) {
                    prosijek = 5;
                } else {
                    prosijek = Double.parseDouble(prosijek_text);
                }
                next_activity.putExtra("prosijek", prosijek);
                next_activity.putExtra("smijer", smijer);

                startActivity(next_activity);

            }
        });
    }
}