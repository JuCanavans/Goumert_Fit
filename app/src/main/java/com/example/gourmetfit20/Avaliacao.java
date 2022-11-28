package com.example.gourmetfit20;

import android.content.Context;
import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gourmetfit20.Screens.TelaAvaliacao;

import java.io.Serializable;
import java.util.List;

@Entity
public class Avaliacao implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "codusuario")
    public int codusuario;
    @ColumnInfo(name = "nota")
    public int nota;
    @ColumnInfo(name = "sugestao")
    public String sugestao;

    public Integer getCodUsuario() {
        return nota;
    }

    public void setCodUsuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }


    public void CadastrarAvaliacao(Avaliacao av, Context co, int codusuario,int nota, String sugestao) {
      //  Log.d("value is" , nota +"-"+sugestao);
        av.setCodUsuario(codusuario);
        av.setNota(nota);
        av.setSugestao(sugestao);
        BaseDados.getInstance(co).avaliacaoDAO().inserirAvaliacao(av);
    }

    public List<Avaliacao> ListaAvaliacao(Context co) {
         List<Avaliacao> la = BaseDados.getInstance(co).avaliacaoDAO().getAll();
         return la;
    }
}
