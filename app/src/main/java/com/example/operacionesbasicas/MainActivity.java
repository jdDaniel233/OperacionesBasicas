package com.example.operacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //METODO PARA CAMBIAR DE ACTIVIDAD
    public void irSuma(View view){
        Intent intent=new Intent(this,SumaActivity.class);
        view.getContext().startActivity(intent);
    }
    public void irResta(View view){
        Intent intent=new Intent(this,RestaActivity.class);
        view.getContext().startActivity(intent);
    }
    /*public void irMultiplicacion(View view){
        Intent intent=new Intent(this,MultiplicacionActivity.class);
        view.getContext().startActivity(intent);
    }
    public void irDivision(View view){
        Intent intent=new Intent(this,DivisionActivity.class);
        view.getContext().startActivity(intent);
    }*/
}