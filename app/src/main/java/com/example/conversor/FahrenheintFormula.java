package com.example.conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class FahrenheintFormula extends AppCompatActivity {

    private ToggleButton tb;
    private TextView mf;
    private TextView calculo;
    private TextView calculoDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahrenheint_formula);

        ImageView voltar = (ImageView) findViewById(R.id.tela1);
        tb = (ToggleButton) findViewById(R.id.formula);
        mf = (TextView) findViewById(R.id.mostrarFormula);

        calculo = (TextView) findViewById(R.id.calculo);
        calculoDois = (TextView) findViewById(R.id.calculoDois);
        Bundle extra = getIntent().getExtras();

        if(extra != null) {
            String temperaturaFahrenheint = extra.getString("tempFah");
            Double tf = Double.parseDouble(temperaturaFahrenheint);

            calculo.setText("(" + temperaturaFahrenheint + " - 32) * 5 / 9 = " + ((tf - 32) * 5 / 9));
            calculoDois.setText("(" + temperaturaFahrenheint + " - 32) * 5 / 9) + 273 = " + ((tf - 32)* 5 / 9 + 273));

        }

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TELA2 = new Intent(FahrenheintFormula.this, Main4Activity.class);
                startActivity(TELA2);
                finish();
            }
        });

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mf.setText("");
                if(isChecked) {
                    mf.setText("Temperatura Celsius = (Temperatura Fahrenheint - 32) * 5 / 9\n\nTemperatura Kelvin = (Temperatura Fahrenheint - 32) * 5 / 9 + 273");
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent TELA1 = new Intent(FahrenheintFormula.this, Main4Activity.class);
        startActivity(TELA1);
        super.onBackPressed();
    }
}