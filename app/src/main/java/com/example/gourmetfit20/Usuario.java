package com.example.gourmetfit20;

import android.content.Context;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Usuario implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "Nome")
    public String nome;
    @ColumnInfo(name = "Email")
    public String email;
    @ColumnInfo(name = "Senha")
    public String senha;
    @ColumnInfo(name = "cpf")
    public String cpf;
/*
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
    @ColumnInfo(name = "h_ou_m")
    public Boolean isMulher;

    @ColumnInfo(name = "imc")
    public Double imc = 0.0;
*/
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
/*
    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public Boolean getMulher() {
        return isMulher;
    }

    public void setMulher(Boolean mulher) {
        isMulher = mulher;
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
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long CadastrarUsuario(Usuario us, Context co, String nome, String senha, String email, String cpf) {
      //  Log.d("value is" , nota +"-"+sugestao);
        us.setNome(nome);
        us.setEmail(email);
        us.setCpf(cpf);
        us.setSenha(senha);
        long id = BaseDados.getInstance(co).UsuarioDAO().InsereUsuario(us);
        return id;
    }

/*
    public void alterarUsuario(email,senha,){


    }

*/
    public Usuario PequisarUsuarioporID(Context co,long id){
        Usuario usu = BaseDados.getInstance(co).UsuarioDAO().getUserById(id);
        return usu;
    }

    public Usuario PequisarUsuarioCPF(Context co,String cpf){
        Usuario usu = BaseDados.getInstance(co).UsuarioDAO().getUserByCPF(cpf);
        return usu;
    }
/*
    public void alterarUsuario(){
        BaseDados.getInstance(co).perfilDAO.updatePerfil(email,senha,nome);

    }


    public Usuario pesquisarUsuario(){
        Usuario usu = new Usuario();
        return usu;
    }
*/



}
