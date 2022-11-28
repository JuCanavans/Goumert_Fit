package com.example.gourmetfit20.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gourmetfit20.BaseDados;
import com.example.gourmetfit20.Calorias;
import com.example.gourmetfit20.R;

import java.util.ArrayList;

public class CadastroCalorias extends AppCompatActivity {


    Button btn_salvarCal,btn_limparCal;
    TextView title_cadastre;
    RadioGroup radioGroup;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7;
    EditText edt_quantCalorias;
    Integer ultimaPosicao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_calorias);
        //recebendo o id do usuário da tela anterior
        Integer user_id = getIntent().getExtras().getInt("user_id");
        //pegando a caloria de acordo com o id do usuário (cpf)
        Calorias calorias = BaseDados.getInstance(this).caloriasDAO().getCaloriaByUserId(user_id);


        title_cadastre = findViewById(R.id.title_cadastre);
        radioGroup = findViewById(R.id.radioGroup);
        edt_quantCalorias = findViewById(R.id.edt_quantCalorias);
        rb1 = findViewById(R.id.rd_dia01);
        rb2 = findViewById(R.id.rd_dia02);
        rb3 = findViewById(R.id.rd_dia03);
        rb4 = findViewById(R.id.rd_dia04);
        rb5 = findViewById(R.id.rd_dia05);
        rb6 = findViewById(R.id.rd_dia06);
        rb7 = findViewById(R.id.rd_dia07);


        onRadioButtonClicked(radioGroup, calorias);

        btn_salvarCal = findViewById(R.id.btn_salvarCal);
        btn_salvarCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chamado sempre ao clicar botao de salvar caloria
                atualizarCaloria(user_id, calorias);
            }
        });

        btn_limparCal = findViewById(R.id.btn_limparCal);
        btn_limparCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chamado sempre ao clicar botao de limpar caloria
                LimpaCaloriaNoBanco(user_id, calorias);
            }
        });


        //setando os textos dos botões para mostrar as calorias do usuário
        rb1.setText("1° Dia " + calorias.getDay_1() + " KCAL");
        rb2.setText("2° Dia " + calorias.getDay_2() + " KCAL");
        rb3.setText("3° Dia " + calorias.getDay_3() + " KCAL");
        rb4.setText("4° Dia " + calorias.getDay_4() + " KCAL");
        rb5.setText("5° Dia " + calorias.getDay_5() + " KCAL");
        rb6.setText("6° Dia " + calorias.getDay_6() + " KCAL");
        rb7.setText("7° Dia " + calorias.getDay_7() + " KCAL");


    }


    //pegando a ultima posicao clicada, conseguimos setar o dia especifico da semana utilizando esse switch case e setando para a caloria do dia do
    //usuario atual o valor recebido no metodo salvarCaloriaPeloDia()
    private void pegarValorDeCaloriasESalvarNoBanco(Integer user_id, Integer position, Calorias calorias) {
        switch (position) {
            case 0:
                calorias.setDay_1(salvarCaloriaPeloDia());
                BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay1(user_id, calorias.getDay_1());
                onBackPressed();
                break;

            case 1:
                calorias.setDay_2(salvarCaloriaPeloDia());
                BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay2(user_id, calorias.getDay_2());
                onBackPressed();
                break;

            case 2:
                calorias.setDay_3(salvarCaloriaPeloDia());
                BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay3(user_id, calorias.getDay_3());
                break;

            case 3:
                calorias.setDay_4(salvarCaloriaPeloDia());
                BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay4(user_id, calorias.getDay_3());
                onBackPressed();
                break;

            case 4:
                calorias.setDay_5(salvarCaloriaPeloDia());
                BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay5(user_id, calorias.getDay_3());
                onBackPressed();
                break;

            case 5:
                calorias.setDay_6(salvarCaloriaPeloDia());
                BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay6(user_id, calorias.getDay_3());
                onBackPressed();
                break;

            case 7:
                calorias.setDay_7(salvarCaloriaPeloDia());
                BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay7(user_id, calorias.getDay_3());
                onBackPressed();
                break;
        }


    }

    //pegando a ultima posicao clicada, conseguimos setar o dia especifico da semana utilizando esse switch case e setando para a caloria do dia do
    //usuario atual o valor recebido no metodo salvarCaloriaPeloDia()
    private void LimpaCaloriaNoBanco(Integer user_id, Calorias calorias) {
        calorias.setDay_1(0.00);
        BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay1(user_id, calorias.getDay_1());
        calorias.setDay_2(0.00);
        BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay2(user_id, calorias.getDay_2());
        calorias.setDay_3(0.00);
        BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay3(user_id, calorias.getDay_3());
        calorias.setDay_4(0.00);
        BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay4(user_id, calorias.getDay_4());
        calorias.setDay_5(0.00);
        BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay5(user_id, calorias.getDay_5());
        calorias.setDay_6(0.00);
        BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay6(user_id, calorias.getDay_6());
        calorias.setDay_7(0.00);
        BaseDados.getInstance(this).caloriasDAO().updateCaloriaDay7(user_id, calorias.getDay_7());
        onBackPressed();
    }


    //método que recupera o valor do edit text e retorna como um double
    private Double salvarCaloriaPeloDia() {
        Double valorKCAL = Double.valueOf(edt_quantCalorias.getText().toString());
        return valorKCAL;
    }

    private Integer getPosition(Integer position) {
        return position;
    }


    //esse método é responsavel por recuperar qual foi o botao de dia que foi clicado
    private void onRadioButtonClicked(RadioGroup radioGroup,Calorias calorias) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rd_dia01:
                        //ultima posicao recebe a ultima posicao de botao clicado
                        ultimaPosicao = getPosition(0);
                        break;
                    case R.id.rd_dia02:
                        ultimaPosicao = getPosition(1);
                        break;
                    case R.id.rd_dia03:
                        ultimaPosicao = getPosition(2);
                        break;
                    case R.id.rd_dia04:
                        ultimaPosicao = getPosition(3);
                        break;
                    case R.id.rd_dia05:
                        ultimaPosicao = getPosition(4);
                        break;
                    case R.id.rd_dia06:
                        ultimaPosicao = getPosition(5);
                        break;
                    case R.id.rd_dia07:
                        ultimaPosicao = getPosition(6);
                        break;
                }
            }
        });
    }



    public void atualizarCaloria(Integer user_id, Calorias calorias) {
        //método para setar a caloria de acordo com o dia da semana
        pegarValorDeCaloriasESalvarNoBanco(user_id, ultimaPosicao, calorias);
        //salvar as calorias injeridas diariamente por cada usuario
        Toast.makeText(getBaseContext(), "Caloria do dia salva com sucesso!", Toast.LENGTH_LONG).show();
    }


}