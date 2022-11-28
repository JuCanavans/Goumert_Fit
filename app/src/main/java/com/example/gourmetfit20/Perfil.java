package com.example.gourmetfit20;

import android.content.Context;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Perfil implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "codusuario")
    public int codusuario;
    @ColumnInfo(name = "Peso")
    public Double peso;
    @ColumnInfo(name = "Altura")
    public Double altura;
    @ColumnInfo(name = "DataI")
    public String data_inicial;
    @ColumnInfo(name = "DataF")
    public String data_final;
    @ColumnInfo(name = "Calorias_Dia")
    public Double calorias_por_dia;
    @ColumnInfo(name = "Atleta")
    public Boolean isAtleta;
    @ColumnInfo(name = "criança_ou_adolescente")
    public Boolean isCrianca;
    /*
    @ColumnInfo(name = "isMulher")
    public Boolean isMulher;


    */
    @ColumnInfo(name = "genero")
    public String genero;
    @ColumnInfo(name = "imc")
    public Double imc = 0.0;

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }
/*
    public Boolean getMulher() {
        return isMulher;
    }

    public void setMulher(Boolean isMulher) {
        this.isMulher = isMulher;
    }
*/
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

    public Double getCalorias_por_dia() {
        return calorias_por_dia;
    }

    public void setCalorias_por_dia(Double calorias_por_dia) {
        this.calorias_por_dia = calorias_por_dia;
    }

    public Boolean getAtleta() {
        return isAtleta;
    }

    public void setAtleta(Boolean atleta) {
        isAtleta = atleta;
    }

    public Boolean getCrianca() {
        return isCrianca;
    }

    public void setCrianca(Boolean crianca) {
        isCrianca = crianca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Perfil PesquisaPerfil(Context co, int codusuario) {
        Perfil perfil = BaseDados.getInstance(co).perfilDAO().PesquisaPerfil(codusuario);
        return perfil;
    }

    public void CadastrarPerfil(Context co,Perfil perfil) {
        BaseDados.getInstance(co).perfilDAO().inserirPerfil(perfil);
    }

/*
    public void alterarPerfil(Context co,Perfil perfil) {
        BaseDados.getInstance(co).perfilDAO().inserirPerfil(perfil);
    }



 */
}
