package com.example.conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoConverter;
    private TextView resultado;
    private TextView mensagemError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        caixaTexto = (EditText) findViewById(R.id.caixaTextold);
        botaoConverter = (Button) findViewById(R.id.botaolConverterld);
        resultado = (TextView) findViewById(R.id.resultadoId);
        mensagemError = (TextView) findViewById(R.id.mensagemErrorId);

        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoDigitado = caixaTexto.getText().toString();
                double valorDigitado;
                double valorResultadoCelsius;
                double valorResultadoKelvin;

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
                    valorResultadoCelsius = (valorDigitado - 32)* 5/9;
                    valorResultadoKelvin = (valorDigitado - 32) * 5/9 + 273;
                    mensagemError.setText("");
                    resultado.setText("A temperatura em celsius é de:\n" + valorResultadoCelsius + "C" + "\nA temperatura em Kelvin é de:\n" + valorResultadoKelvin + "K");

                }
            }
        });

        Button voltar = findViewById(R.id.tela1);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TELA4 = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(TELA4);
                finish();
            }
        });

    }
}