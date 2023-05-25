package com.example.operacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MultiplicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion);
    }
    public void regresarMenu(View view){
        this.finish();
    }

    public void multiplicar(View view) {
        EditText numero1 = (EditText) findViewById(R.id.num1);
        EditText numero2 = (EditText) findViewById(R.id.num2);
        TextView total = findViewById(R.id.result);
        double resultado = Double.parseDouble(numero1.getText().toString()) * Double.parseDouble(numero2.getText().toString());
        total.setText(resultado+"");
    }
}