package com.example.gourmetfit20.Screens;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gourmetfit20.BaseDados;
import com.example.gourmetfit20.Calorias;
import com.example.gourmetfit20.Perfil;
import com.example.gourmetfit20.R;
import com.example.gourmetfit20.Usuario;

import java.text.DecimalFormat;

public class TelaRelatorio extends AppCompatActivity {


    TextView title_cadastre;
    EditText View_CalsTotal;
    EditText edt_IMC;
    EditText edt_q_posso;
    EditText edt_Dica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_historico);
        title_cadastre = findViewById(R.id.title_cadastre);
        View_CalsTotal = findViewById(R.id.View_CalsTotal);
        edt_IMC = findViewById(R.id.edt_IMC);
        edt_q_posso = findViewById(R.id.edt_q_posso);
        edt_Dica = findViewById(R.id.edt_Dica);


        //recuperando dados do usuario e das calorias dele
        Integer user_id = getIntent().getExtras().getInt("user_id");
        Usuario currentUser = (Usuario) getIntent().getSerializableExtra("current_user");
        Perfil perfil = BaseDados.getInstance(this).perfilDAO().PesquisaPerfil(currentUser.getId());
        Calorias calorias = BaseDados.getInstance(this).caloriasDAO().getCaloriaByUserId(user_id);



        View_CalsTotal.setText(somarCaloriasInjeridas(calorias).toString() + " KCAL");
        edt_IMC.setText(String.format("%.2f",recuperarIMC(perfil)));
        edt_q_posso.setText(calcularQTDdeCaloriaQueAindaPodeComer(perfil, calorias).toString() + " KCAL");
        //metodo responsavel por verificar se o usuario cumpriu a meta
        calcularSeOUsuarioCumpriuMeta(calorias, perfil);

    }

    private Float somarCaloriasInjeridas(Calorias calorias) {
        //recebe os valores de calorias diarias e realiza a soma delas
        Double total_calorias = calorias.getDay_1() + calorias.getDay_2() + calorias.getDay_3() + calorias.getDay_4() + calorias.getDay_5() + calorias.getDay_6() + calorias.getDay_7();
        return Float.parseFloat(total_calorias.toString());
    }

    private Double recuperarIMC(Perfil perfil) {
        //recebe dados do usuário e calcula o imc
        Double resultIMC = perfil.peso / (perfil.altura * perfil.altura);
        //Problema com . e , no decimal, "." funciona no emulador porem "," funciona direto no aparelho

        //return String.format("%.2f", resultIMC);
        //DecimalFormat df =  new DecimalFormat("0.00");
        return resultIMC;
    }

    private String calcularQTDdeCaloriaQueAindaPodeComer(Perfil perfil, Calorias calorias) {
        //recebe o valor que foi setado como meta de caloria
        Double caloriaSetadaParaInjerir = perfil.getCalorias_por_dia();

        //recebe os valores de calorias diarias e realiza a soma delas
        Double total_calorias = calorias.getDay_1() + calorias.getDay_2() + calorias.getDay_3() + calorias.getDay_4() + calorias.getDay_5() + calorias.getDay_6() + calorias.getDay_7();

        //subtrai o calor setado de caloria por dia pelo total de caloria consumida na semana para retornar o valor do quanto ainda pode consumir
        Double totalQuePodeConsumirAinda = caloriaSetadaParaInjerir - total_calorias;

        if (totalQuePodeConsumirAinda < 0){
            //criamos uma variavel auxiliar para realizar a subtracao entre o total de calorias que o usuario consumiu e o total setado para consumir semanalmente para recebemos um valor
            //de quantos KCAL a mais ele consumiu
            Double aux = total_calorias - totalQuePodeConsumirAinda;
            return "Você está consumindo mais do que deveria: " + Float.parseFloat(aux.toString()) + " KCAL";
        }else{
            return String.valueOf(Float.parseFloat(totalQuePodeConsumirAinda.toString()));
        }

    }

    private void calcularSeOUsuarioCumpriuMeta(Calorias calorias, Perfil perfil){
        //recebe a soma de todos os valores de calorias salvos para todos os 7 dias
        Double total_calorias = calorias.getDay_1() + calorias.getDay_2() + calorias.getDay_3() + calorias.getDay_4() + calorias.getDay_5() + calorias.getDay_6() + calorias.getDay_7();
        //recebe o valor que foi setado como meta de caloria
        Double caloriaSetadaParaInjerir = perfil.getCalorias_por_dia();
        //subtrai o calor setado de caloria por dia pelo total de caloria consumida na semana para retornar o valor do quanto ainda pode consumir
        Double totalQuePodeConsumirAinda = caloriaSetadaParaInjerir - total_calorias;

        //verificando se cumpriu a meta
        if (totalQuePodeConsumirAinda <= 0){
            edt_Dica.setText("Você cumpriu sua meta!");
        }else{
            edt_Dica.setText("Não cumpriu sua meta!");
        }

    }


}

