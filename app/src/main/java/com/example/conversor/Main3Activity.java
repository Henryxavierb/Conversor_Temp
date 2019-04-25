package com.example.conversor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoConverter;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        caixaTexto = (EditText) findViewById(R.id.caixaTextold);
        botaoConverter = (Button) findViewById(R.id.botaolConverterld);
        resultado = (TextView) findViewById(R.id.resultadoId);

        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoDigitado = caixaTexto.getText().toString();
                double valorDigitado;
                double valorResultadoCelsius;
                double valorResultadoFareheint;

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
                    valorResultadoCelsius = valorDigitado - 273;
                    valorResultadoFareheint = (valorDigitado - 273) * 9/5 + 32;
                    resultado.setText("A temperatura em celsius é de:\n" + valorResultadoCelsius + "C" + "\nA temperatura em Fahrenheint é de:\n" + valorResultadoFareheint + "F");

                }
            }
        });

        Button voltar = findViewById(R.id.tela1);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TELA3 = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(TELA3);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent TELA1 = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(TELA1);
        super.onBackPressed();
    }
}
