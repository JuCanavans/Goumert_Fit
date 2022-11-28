package com.example.gourmetfit20;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UsuarioDAO {
    @Insert
    long InsereUsuario(Usuario nome);

    @Query("SELECT * FROM Usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM Usuario WHERE email=(:emailcc) and senha=(:senhacc)")
    Usuario Logar(String emailcc, String senhacc);

    @Query("SELECT * FROM Usuario WHERE id=(:id)")
    Usuario getUserById(long id);

    @Query("SELECT * FROM Usuario WHERE cpf=(:cpf)")
    Usuario getUserByCPF(String cpf);

/*    @Query("UPDATE Usuario SET imc = (:imc) WHERE id = (:id)")
    void updateImcById(Integer id, Double imc);

    @Query("UPDATE Usuario SET peso = (:peso), altura = (:altura), DataI = (:data_inicial), DataF = (:data_final), Calorias_Dia = (:calorias_por_dia), Atleta = (:isAtelta), criança_ou_adolescente = (:isCrianca), h_ou_m = (:isMulher) WHERE id = (:id)")
    void updateUsuario(Integer id, Double peso, Double altura, String data_inicial, String data_final, Double calorias_por_dia, Boolean isAtelta, Boolean isCrianca, Boolean isMulher);
*/



    //  @Delete
    //   void DeletarConta(Usuario conta);
    // @Delete
    // void resetListaContas(List<ContaCorrente>conta);
    //   @Query("UPDATE Usuario SET Nome = :Snome, Email =:Semail, Senha =:Ssenha  WHERE id = :Sid")
    //    void update(int Sid, String Snome,String Semail,String Ssenha);
    //@Query("UPDATE ContaCorrente SET Nome = :Snome WHERE id = :Sid")
    // void update(int Sid, String Snome);
}
