package com.example.gourmetfit20.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gourmetfit20.BaseDados;
import com.example.gourmetfit20.CalculoIMC;
import com.example.gourmetfit20.Calorias;
import com.example.gourmetfit20.Screens.TelaPerfil;
import com.example.gourmetfit20.R;
import com.example.gourmetfit20.Usuario;

public class TelaPrincipal extends AppCompatActivity {


    Button btn_InserirCalorias, btn_CalcularIMC, btn_EditarPerfil, btn_GerarHistorico,
            btn_Avaliacao;
    TextView title_cadastre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //Aqui recebemos o usuário atual passado na tela anterior
        Usuario current_user = (Usuario) getIntent().getSerializableExtra("current_user");
        //método para retorar a caloria do usuário de acordo com o cpf -- Alterado para pegar pelo ID
        Calorias calorias = BaseDados.getInstance(this).caloriasDAO().getCaloriaByUserId(current_user.id);

        //se a categoria não for nula, habilitamos o botão gerar histórico. Se caso ela seja, não habilitamos pois o usuário ainda não tem histórico
        if (calorias != null) {
            btn_GerarHistorico = findViewById(R.id.btn_GerarHistorico);
            btn_GerarHistorico.setVisibility(View.VISIBLE);
            btn_GerarHistorico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gerarHistorico(calorias.getId_tabela_caloria_que_é_o_mesmo_id_do_usuário(), current_user);
                }
            });
        }


        title_cadastre = findViewById(R.id.title_cadastre);

        btn_InserirCalorias = findViewById(R.id.btn_CalcularIMC_Principal);
        btn_InserirCalorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirCalorias(current_user.id);
            }

        });

        btn_CalcularIMC = findViewById(R.id.btn_CalcularIMC);
        btn_CalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularIMC(current_user.id);
            }

        });


        btn_EditarPerfil = findViewById(R.id.btn_EditarPerfil);
        btn_EditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarPerfil(current_user);
            }
        });


        //Incluido botão para avaliação - Arthur Vieira - 16/11/2022
        btn_Avaliacao = findViewById(R.id.btn_Avaliacao);
        btn_Avaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Avaliacao(current_user);
            }
        });

    }

    public void inserirCalorias(Integer user_id) {
        Intent telaConta = new Intent(this, CadastroCalorias.class);
        //aqui passamos o id so usuário para a tela de cadastro de calorias (é o cpf)
        telaConta.putExtra("user_id", user_id);
        startActivity(telaConta);
    }

    public void calcularIMC(Integer user_id) {
        Intent telaConta = new Intent(this, CalculoIMC.class);
        //aqui passamos o id so usuário para a tela de cadastro de calorias (é o cpf)
        telaConta.putExtra("user_id", user_id);
        startActivity(telaConta);
    }

    public void editarPerfil(Usuario currentUser) {
        Intent telaConta = new Intent(this, TelaPerfil.class);
        //utilizamos esse trecho de código para passar esse usuário atual para a proxima tela
        telaConta.putExtra("current_user", currentUser);
        startActivity(telaConta);
    }

    //função para chamada da tela de Avaliação - Arthur Vieira - 16/11/2022
    public void Avaliacao(Usuario current_user) {
        Intent telaConta = new Intent(this, TelaAvaliacao.class);
        //utilizamos esse trecho de código para passar esse usuário atual para a proxima tela
        telaConta.putExtra("current_user", current_user);
        startActivity(telaConta);
    }

    public void gerarHistorico(Integer user_id, Usuario current_user) {
        Intent telaConta = new Intent(this, TelaRelatorio.class);
        //utilizamos esse trecho de código para passar esse usuário atual e o id dele para a proxima tela
        telaConta.putExtra("user_id", user_id);
        telaConta.putExtra("current_user", current_user);
        startActivity(telaConta);
    }

}