package com.example.conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class CelsiusFormula extends AppCompatActivity {

    private ToggleButton tb;
    private TextView mf;
    private TextView calculo;
    private TextView calculoDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celsius_formula);

        ImageView voltar = (ImageView) findViewById(R.id.tela1);
        tb = (ToggleButton) findViewById(R.id.formula);
        mf = (TextView) findViewById(R.id.mostrarFormula);

        calculo = (TextView) findViewById(R.id.calculo);
        calculoDois = (TextView) findViewById(R.id.calculoDois);
        Bundle extra = getIntent().getExtras();

        if(extra != null) {
            String temperaturaCelcius = extra.getString("tempCelcius");
            Double tc = Double.parseDouble(temperaturaCelcius);

            calculo.setText("273.0 + " + temperaturaCelcius + " = " + (tc + 273));
            calculoDois.setText("(" + temperaturaCelcius + " * 9 / 5) + 32 = " + ((tc * 9 / 5) + 32));


        }

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TELA2 = new Intent(CelsiusFormula.this, Main2Activity.class);
                startActivity(TELA2);
                finish();
            }
        });

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mf.setText("");
                if(isChecked) {
                    mf.setText("Temperatura Kelvin = Temperatura Celsius + 273 \n\n Temperatura Farenheint = (Temperatura Celsius * 9 / 5) + 32");
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent TELA1 = new Intent(CelsiusFormula.this, Main2Activity.class);
        startActivity(TELA1);
        super.onBackPressed();
    }
}
