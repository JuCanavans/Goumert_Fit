package com.example.gourmetfit20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CalculoIMC extends AppCompatActivity {


    EditText edt_altura, edt_peso;
    Button btn_CalcularIMC_Principal;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);
        //recebendo o id do usuário da tela anterior
        Integer user_id = getIntent().getExtras().getInt("user_id");


        String IMCabaixo = "Peso abaixo do ideal";
        String IMCmedia = "Seu peso esta ideal";
        String IMCacima = "Peso acima do recomendado.";


        edt_altura = findViewById(R.id.edt_altura);
        edt_peso = findViewById(R.id.edt_peso);
        txtResult = findViewById(R.id.textView5);

        btn_CalcularIMC_Principal = findViewById(R.id.btn_CalcularIMC_Principal);
        btn_CalcularIMC_Principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se os campos de textos não forem nulos
                if (!edt_altura.getText().toString().equals("") || !edt_peso.getText().toString().equals("")) {
                    mudarNomeDeAcordocomIMC(IMCabaixo, IMCmedia, IMCacima);
                    BaseDados.getInstance(CalculoIMC.this).perfilDAO().updateImcById(user_id, calcularIMC());
                }

            }

        });

    }


    //trocar o valor de resultaod de acordo com o valor do imc
    private void mudarNomeDeAcordocomIMC(String IMCabaixo, String IMCmedia, String IMCacima) {
        if (calcularIMC() < 18.5) {
            txtResult.setText("Salvo com IMC de: "+ IMCabaixo);
        } else if (calcularIMC() >= 18.5 && calcularIMC() <= 24.9) {
            txtResult.setText("Salvo com IMC de: "+ IMCmedia);
        } else {
            txtResult.setText("Salvo com IMC de: "+ IMCacima);
        }
    }


    //método pra calcular IMC
    public double calcularIMC() {
        Double peso = Double.valueOf(edt_peso.getText().toString());
        Double altura = Double.valueOf(edt_altura.getText().toString());
        return peso / (altura * altura);
    }

}