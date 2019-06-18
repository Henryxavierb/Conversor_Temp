package com.example.conversor;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button graus  = findViewById(R.id.tela2);
        Button kelvin  = findViewById(R.id.tela3);
        Button fahrenheit  = findViewById(R.id.tela4);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_button);

        graus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent TELA1 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(TELA1);
                finish();
            }
        });

        kelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent TELA3 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(TELA3);
                finish();
            }
        });

        fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent TELA4 = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(TELA4);
                finish();
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Selecione uma opção de conversor", Toast.LENGTH_SHORT).show();
    }
    public void onBackPressed() {
        super.onBackPressed();
    }
}
