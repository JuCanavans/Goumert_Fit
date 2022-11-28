package com.example.gourmetfit20.Screens;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gourmetfit20.BaseDados;
import com.example.gourmetfit20.R;

public class MainActivity extends AppCompatActivity {

    Button btn_Acessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Banco de Dados SQLite
        try {
            // Criando Banco de Dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("BD-GOURMETFIT", MODE_PRIVATE, null);
            //Log.i("BD",bancoDados.getPath().toString());
            // Criando Tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS Calorias ( codCaloria AUTOINCREMENTE, quantCaloria INT )");
        } catch (Exception e) {
            e.printStackTrace();
        }





        btn_Acessar = findViewById(R.id.btn_Logar);
        btn_Acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acessando();
            }

        });
    }

    public void acessando() {  // Chama segunda tela.

        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);


    }



}
