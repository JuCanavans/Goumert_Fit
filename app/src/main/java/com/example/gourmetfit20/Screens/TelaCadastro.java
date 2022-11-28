package com.example.gourmetfit20.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gourmetfit20.BaseDados;
import com.example.gourmetfit20.Screens.TelaPerfil;
import com.example.gourmetfit20.R;
import com.example.gourmetfit20.Usuario;

public class TelaCadastro extends AppCompatActivity {

    EditText nome, email, senha, cpf,senhaconfirm;
    Button gravar, btn_CriarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nome = findViewById(R.id.edt_nome);
        email = findViewById(R.id.edt_email);
        //Incluido o CPF no cadastro do usuário
        cpf   = findViewById(R.id.edt_cpf);
        senha = findViewById(R.id.edt_senha);
        senhaconfirm = findViewById(R.id.edt_senhaconfirm);
        gravar = findViewById(R.id.btn_CalcularIMC_Principal);
        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GravarDados();
            }
        });

    }

    public void GravarDados() {

       // Log.i("SENHAS:",senha.getText().toString()+" != "+senhaconfirm.getText().toString());

        if (senha.getText().toString().isEmpty() && senhaconfirm.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencher os 2 campos de senha!!", Toast.LENGTH_LONG).show();
        } else if ( !senhaconfirm.getText().toString().equals(senha.getText().toString()) ) {
            Toast.makeText(this, "Senhas diferentes!!", Toast.LENGTH_LONG).show();
        } else {
            Usuario cc = new Usuario();
            cc.setNome(nome.getText().toString());
            cc.setEmail(email.getText().toString());
            cc.setSenha(senha.getText().toString());
            cc.setCpf(cpf.getText().toString());
            //cria cadastro do Usuario
            long id_user = cc.CadastrarUsuario(cc, this, nome.getText().toString(), senha.getText().toString(), email.getText().toString(), cpf.getText().toString());
            //busca usario por ID para passar para Perfil
            cc = cc.PequisarUsuarioporID(this, id_user);

            //recupera o usuário atual baseado no email dele, pois o metodo insert retorna void
            //passando o usuario pra tela de criar perfil pra recuperar os dados dele
            criarPerfil(cc);
            // Exibe Mensagem de dados inseridos com sucesso!
        }
    }

    public void criarPerfil(Usuario usuario) {
        Intent intent = new Intent(this, TelaPerfil.class);
        intent.putExtra("current_user", usuario);
        startActivity(intent);
    }


}