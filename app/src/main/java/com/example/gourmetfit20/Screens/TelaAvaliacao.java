package com.example.gourmetfit20.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gourmetfit20.Avaliacao;
import com.example.gourmetfit20.R;
import com.example.gourmetfit20.Usuario;

import java.util.List;

public class TelaAvaliacao extends AppCompatActivity {

    Button btn_salvar_feedback;
    EditText  edt_nota, edt_sugestao;

    int codUsuario ;
    int nota;
    String sugestao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        //Pegar usuario do app
        Usuario current_user = (Usuario) getIntent().getSerializableExtra("current_user");

        edt_nota = findViewById(R.id.edt_nota);
        edt_sugestao = findViewById(R.id.edt_sugestao);

        btn_salvar_feedback = findViewById(R.id.btn_salvar_feedback);
        btn_salvar_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {SalvarAvaliacao(current_user.getId(), Integer.valueOf(edt_nota.getText().toString()),edt_sugestao.getText().toString());
            }
        });
    }



    public void SalvarAvaliacao(int codusuario,int nota, String sugestao) {

        Avaliacao av = new Avaliacao();
        av.CadastrarAvaliacao(av,this,codusuario,nota,sugestao);

        Toast.makeText(getBaseContext(), "Obrigado pelo FeedBack! ", Toast.LENGTH_SHORT).show();
        onBackPressed();

    }
    /*

    cadastrarAvalicao (){




    }


    emitirRelatorio(){



    }

*/



}