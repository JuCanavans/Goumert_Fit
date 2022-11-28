package com.example.gourmetfit20.Screens;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gourmetfit20.BaseDados;
import com.example.gourmetfit20.R;
import com.example.gourmetfit20.Usuario;


public class TelaLogin extends AppCompatActivity {

    EditText emailC, senhaC;
    TextView txt_CriarConta;
    Button btn_Logar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        txt_CriarConta = findViewById(R.id.txt_CriarConta);
        txt_CriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrando();
            }
        });


        emailC = findViewById(R.id.emailC);
        senhaC = findViewById(R.id.senhaC);
        btn_Logar = findViewById(R.id.btn_Logar);
        btn_Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logando();
            }

        });


    }

    public void cadastrando() {  // Chama tela cadastro.

        Intent intent = new Intent(this, TelaCadastro.class);
        startActivity(intent);


    }

    public void Logando() {
        String c = emailC.getText().toString();
        String s = senhaC.getText().toString();

        //verifica se ta tudo correto com os campos de textos, se sim, chama o metodo logar
        if (emailC.getText().toString().isEmpty() && senhaC.getText().toString().isEmpty()) {
            Toast.makeText(this, "DADOS FALTANDO. TODOS OS CAMPOS SAO OBRIGATORIOS ", Toast.LENGTH_LONG).show();
        } else if (BaseDados.getInstance(this).UsuarioDAO().Logar(c, s) == null) {
            Toast.makeText(this, "LOGIN INVÁLIDO", Toast.LENGTH_LONG).show();
        } else if (BaseDados.getInstance(this).UsuarioDAO().Logar(c,s) != null){
            //aqui quando o método logar é chamado, ele retorna um objeto Usuário, que é o usuário atual logado
            Usuario currentUser = BaseDados.getInstance(this).UsuarioDAO().Logar(c,s);
            Intent telaConta = new Intent(this, TelaPrincipal.class);

            //utilizamos esse trecho de código para passar esse usuário atual para a proxima tela
            telaConta.putExtra("current_user", currentUser);
            startActivity(telaConta);

        }


    }


}


