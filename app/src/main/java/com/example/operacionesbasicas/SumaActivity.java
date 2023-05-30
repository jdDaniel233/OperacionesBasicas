package com.example.operacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SumaActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    private Button btnVoiceInput;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);

        btnVoiceInput = findViewById(R.id.Microfono);
        tvResultado = findViewById(R.id.txtResultado);


        btnVoiceInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });
    }
    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String speechText = result.get(0);

            // Separar la cadena de texto en palabras
            String[] words = speechText.split(" ");

            int numero1 = 0;
            int numero2 = 0;

            // Intentar convertir las palabras en números
            try {
                numero1 = Integer.parseInt(words[0]);
                numero2 = Integer.parseInt(words[2]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                Toast.makeText(this, "Error al reconocer los números", Toast.LENGTH_SHORT).show();
                return;
            }

            // Realizar la suma
            int resultado = numero1 + numero2;

            // Mostrar el resultado en pantalla
            tvResultado.setText("Resultado: " + resultado);
        }
    }



    public void regresarMenu(View view){
       this.finish();
    }

    public void sumar(View view) {
        EditText numero1 = (EditText) findViewById(R.id.txtNumero1);
        EditText numero2 = (EditText) findViewById(R.id.txtNumero2);
        TextView total = findViewById(R.id.txtResultado);
        double resultado = Double.parseDouble(numero1.getText().toString()) + Double.parseDouble(numero2.getText().toString());
        total.setText(resultado+"");
    }
}