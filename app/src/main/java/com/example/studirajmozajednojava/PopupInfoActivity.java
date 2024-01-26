package com.example.studirajmozajednojava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView phone = findViewById(R.id.phonePopup);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView email = findViewById(R.id.emailPopup);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView name = findViewById(R.id.textNamePopupInfo);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView desc = findViewById(R.id.textDescPopupInfo);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView smijerovi = findViewById(R.id.textSmijeroviPopupInfo);
        ImageView image = findViewById(R.id.imagePopupInfo);
        Intent lastIntent = getIntent();
        phone.setText(Fakulteti.fakultetiList[lastIntent.getIntExtra("fakultet_index", 0)].phoneNum);
        email.setText(Fakulteti.fakultetiList[lastIntent.getIntExtra("fakultet_index", 0)].email);
        name.setText(Fakulteti.fakultetiList[lastIntent.getIntExtra("fakultet_index", 0)].name);
        desc.setText(Fakulteti.fakultetiList[lastIntent.getIntExtra("fakultet_index", 0)].desc);
        image.setImageResource(Fakulteti.fakultetiList[lastIntent.getIntExtra("fakultet_index", 0)].picId);
        StringBuilder smijeroviText = new StringBuilder("Ponuđeni studiji:\n");
        for (CharSequence c :
                Fakulteti.fakultetiList[lastIntent.getIntExtra("fakultet_index", 0)].smjerovi) {
            smijeroviText.append(c+"\n");
        }
        smijerovi.setText(smijeroviText);
    }
}