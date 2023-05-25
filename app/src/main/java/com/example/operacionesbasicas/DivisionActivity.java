package com.example.operacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DivisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
    }
    public void regresarMenu(View view){
        this.finish();
    }

    public void division(View view) {
        EditText numero1 = (EditText) findViewById(R.id.txtnum1);
        EditText numero2 = (EditText) findViewById(R.id.txtnum2);
        TextView total = findViewById(R.id.txtresult);
        double resultado = Double.parseDouble(numero1.getText().toString()) / Double.parseDouble(numero2.getText().toString());
        total.setText(resultado+"");
    }
}