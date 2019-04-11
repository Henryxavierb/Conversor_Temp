package com.example.conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoConverter;
    private TextView resultado;
    private TextView mensagemError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        caixaTexto = (EditText) findViewById(R.id.caixaTextold);
        botaoConverter = (Button) findViewById(R.id.botaolConverterld);
        resultado = (TextView) findViewById(R.id.resultadoId);
        mensagemError = (TextView) findViewById(R.id.mensagemErrorId);

        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoDigitado = caixaTexto.getText().toString();
                double valorDigitado;
                double valorResultadoKelvin;
                double valorResultadoFareheint;

                if (textoDigitado.isEmpty()) {
                    mensagemError.setText("Nenhum numero digitado!!!");

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
                    mensagemError.setText("");
                    resultado.setText("A temperatura em Kelvin é de:\n" + valorResultadoKelvin + "K" + "\nA temperatura em Fahrenheint é de:\n" + valorResultadoFareheint + "F");

                }
            }
        });

        Button voltar = findViewById(R.id.tela1);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TELA2 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(TELA2);
                finish();
            }
        });

    }
}