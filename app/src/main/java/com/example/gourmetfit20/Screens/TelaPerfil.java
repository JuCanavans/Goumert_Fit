package com.example.gourmetfit20.Screens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gourmetfit20.BaseDados;
import com.example.gourmetfit20.Calorias;
import com.example.gourmetfit20.Perfil;
import com.example.gourmetfit20.R;
import com.example.gourmetfit20.Screens.TelaLogin;
import com.example.gourmetfit20.Usuario;

public class TelaPerfil extends AppCompatActivity {

    Button btnSalvar_Perfil, btn_atualizar_perfil;
    EditText etPeso, etAltura, etDataI, etDataF, etObjetivo, etGenero, etCpf;
    CheckBox checkAtleta, checkAdulto, checkHomem;
    TextView title_cadastre;
    Integer isSomething = 0;
    String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        etPeso = findViewById(R.id.etPeso);
        title_cadastre = findViewById(R.id.title_cadastre);
        etAltura = findViewById(R.id.etAltura);
        etDataI = findViewById(R.id.etDataI);
        etDataF = findViewById(R.id.etDataF);
        etObjetivo = findViewById(R.id.etObjetivo);
        etGenero = findViewById(R.id.etGenero);
        //checkHomem = findViewById(R.id.checkMulher);
        checkAdulto = findViewById(R.id.checkAdulto);
        checkAtleta = findViewById(R.id.checkAtleta);
        btnSalvar_Perfil = findViewById(R.id.btnSalvar_Perfil);
        btn_atualizar_perfil = findViewById(R.id.btn_atualizar_perfil);
        //etCpf = findViewById(R.id.etCpf);


        //recupera o usuario atual da tela anterior
            Usuario usuario = (Usuario) getIntent().getSerializableExtra("current_user");
        Perfil perfil = Perfil.PesquisaPerfil(this,usuario.getId());
        //verifica se o usuario atual não está null
        if (perfil != null) {
            btnSalvar_Perfil.setVisibility(View.GONE);
            btn_atualizar_perfil.setVisibility(View.VISIBLE);
            setarValoresParaATeladePerfil(perfil, this, usuario);
        } else {
            title_cadastre.setText("Finalize seu cadastro " + usuario.getNome());
            btnSalvar_Perfil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //chamada do metodo para cadastrar perfil de usuario
                    Perfil perfil = new Perfil();
                    perfil.setCodusuario(usuario.getId());
                    //Log.i("PERFIL1",String.valueOf(perfil.getCodusuario()));
                    Perfil perfil_para_ser_salvo = setarDadosDoPerfilPraSalvar(perfil);
                    cadastrarperfil(perfil_para_ser_salvo, TelaPerfil.this);
                }
            });

        }
    }


    @SuppressLint("ResourceType")
    private void setarValoresParaATeladePerfil(Perfil perfil, Context context, Usuario usuario) {
        //setando os valores para os edit texts com as informações recebidas do usuário da tela anterior, caso exista
        etPeso.setText(perfil.getPeso().toString());
        title_cadastre.setText("Olá " + usuario.getNome());
        etAltura.setText(perfil.getAltura().toString());
        etDataI.setText(perfil.getData_inicial());
        etDataF.setText(perfil.getData_final());
        etObjetivo.setText(perfil.getCalorias_por_dia().toString());
        //etCpf.setText(perfil.getCpf().toString());
        etGenero.setText(perfil.getGenero());

        checkAtleta.setChecked(perfil.getAtleta());
        checkAdulto.setChecked(perfil.getCrianca());
        //checkHomem.setChecked(perfil.getMulher());



        btn_atualizar_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chamada do metodo que atualiza o perfil do usuario
                atualizarPerfil(setarDadosDoPerfilPraSalvar(perfil));
            }
        });


    }


    private Perfil setarDadosDoPerfilPraSalvar(Perfil perfil) {

        //aqui para caso o usuário recebido da outra tela não exista, signifca que nós ainda estamos cadastrando um usuario
        //entao pegamos as informações escritas nos edit texts e retornamos em um objeto usuario para salvar
        perfil.setPeso(Double.valueOf(etPeso.getText().toString()));
        perfil.setAltura(Double.valueOf(etAltura.getText().toString()));
        perfil.setData_inicial(etDataI.getText().toString());
        perfil.setData_final(etDataF.getText().toString());
        perfil.setCalorias_por_dia(Double.valueOf(etObjetivo.getText().toString()));
        perfil.setGenero(etGenero.getText().toString());

//        boolean isMan   = checkHomem.isChecked();
        boolean isAdult = checkAdulto.isChecked();
        boolean isAtlet = checkAtleta.isChecked();

        perfil.setAtleta(isAtlet);
        perfil.setCrianca(isAdult);
        return perfil;
    }



    private void atualizarPerfil(Perfil perfil) {
        //metodo responsavel por atualizar o perfil do usuario no banco de acordo com o id dele
        BaseDados.getInstance(this).perfilDAO().updatePerfil(perfil.getId(), perfil.getPeso(), perfil.altura, perfil.data_inicial, perfil.data_final, perfil.calorias_por_dia, perfil.isAtleta, perfil.isCrianca, perfil.genero);
        onBackPressed();
    }



    private void cadastrarperfil(Perfil Perfil, Context context) {
        //metodo responsavel por cadastrar um usuario no banco e, juntamente com ele, uma tabela de caloria para ele setando como id o cpf do usuario
        //BaseDados.getInstance(this).perfilDAO().inserirPerfil(setarDadosDoPerfilPraSalvar(Perfil));
        Perfil.CadastrarPerfil(this,Perfil);
        Calorias calorias = new Calorias();
        //calorias.setId_tabela_caloria_que_é_o_mesmo_id_do_usuário(usuario.getCpf());
        BaseDados.getInstance(this).caloriasDAO().inserirCaloria(calorias);
        startActivity(new Intent(context, TelaLogin.class));
    }

}