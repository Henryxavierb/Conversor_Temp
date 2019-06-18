package com.example.conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main4Activity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoConverter;
    private TextView resultado;
    private Button btn;
    private TextView mf;
    double valorDigitado;
    double valorResultadoCelsius;
    double valorResultadoKelvin;
    String textoDigitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        caixaTexto = (EditText) findViewById(R.id.caixaTextold);
        botaoConverter = (Button) findViewById(R.id.botaolConverterld);
        resultado = (TextView) findViewById(R.id.resultadoId);
        btn = (Button) findViewById(R.id.formula);
        mf = (TextView) findViewById(R.id.mostrarFormula);

        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textoDigitado = caixaTexto.getText().toString();

                if (textoDigitado.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Digite um valor!", Toast.LENGTH_SHORT).show();

                } else {
                    if (textoDigitado.startsWith("-")) {
                        String[] msgSplit = textoDigitado.split("-");
                        valorDigitado = Double.parseDouble(msgSplit[1]);
                        valorDigitado = 0 - valorDigitado;
                    } else {
                        valorDigitado = Double.parseDouble(textoDigitado);
                    }
                    valorResultadoCelsius = (valorDigitado - 32)* 5/9;
                    valorResultadoKelvin = (valorDigitado - 32) * 5/9 + 273;
                    resultado.setText("Celsius: " + valorResultadoCelsius + "C" + "\nKelvin: " + valorResultadoKelvin + "K");

                }
            }
        });

        ImageView voltar = findViewById(R.id.tela1);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TELA3 = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(TELA3);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoDigitado = caixaTexto.getText().toString();

                Intent TELA2 = new Intent(Main4Activity.this, FahrenheintFormula.class);
                TELA2.putExtra("tempFah", textoDigitado);
                startActivity(TELA2);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent TELA1 = new Intent(Main4Activity.this, MainActivity.class);
        startActivity(TELA1);
        super.onBackPressed();
    }
}
