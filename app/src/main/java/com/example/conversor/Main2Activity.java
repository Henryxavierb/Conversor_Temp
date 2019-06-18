package com.example.conversor;

import android.app.PendingIntent;
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

public class Main2Activity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoConverter;
    private TextView resultado;
    private Button btn;
    private TextView mf;
    double valorDigitado;
    double valorResultadoKelvin;
    double valorResultadoFareheint;
    String textoDigitado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
                    valorResultadoKelvin = 273 + valorDigitado;
                    valorResultadoFareheint = (valorDigitado * 9 / 5) + 32;
                    resultado.setText("Kelvin: " + valorResultadoKelvin + "K" + "\n\nFahrenheint: " + valorResultadoFareheint + "F");
                }
            }
        });

        ImageView voltar = (ImageView) findViewById(R.id.tela1);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TELA2 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(TELA2);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoDigitado = caixaTexto.getText().toString();

                Intent TELA2 = new Intent(Main2Activity.this, CelsiusFormula.class);
                TELA2.putExtra("tempCelcius", textoDigitado);
                startActivity(TELA2);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent TELA1 = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(TELA1);
        super.onBackPressed();
    }
}
