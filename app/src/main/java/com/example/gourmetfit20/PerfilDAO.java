package com.example.gourmetfit20;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PerfilDAO {

    @Insert
    void inserirPerfil(Perfil perfil);

    @Query("SELECT * FROM Perfil")
    List<Perfil> getAll();

    @Query("UPDATE Perfil SET imc = (:imc) WHERE id = (:id)")
    void updateImcById(Integer id, Double imc);

    @Query("UPDATE Perfil SET peso = (:peso), altura = (:altura), DataI = (:data_inicial), DataF = (:data_final), Calorias_Dia = (:calorias_por_dia), Atleta = (:isAtelta), criança_ou_adolescente = (:isCrianca), genero = (:genero) WHERE id = (:id)")
    void updatePerfil(Integer id, Double peso, Double altura, String data_inicial, String data_final, Double calorias_por_dia, Boolean isAtelta, Boolean isCrianca, String genero);

    @Query("Select * from Perfil WHERE codusuario = (:codusuario)")
    Perfil PesquisaPerfil(int codusuario);


/*
    @Query("UPDATE Avaliacao SET nota = (:day_1) WHERE id_usuario = (:id)")
    void updateSugestao(Integer id, Double day_1);

    @Query("UPDATE Calorias SET day_2 = (:day_2) WHERE id_usuario = (:id)")
    void updateCaloriaDay2(Integer id, Double day_2);

    @Query("UPDATE Calorias SET day_3 = (:day_3) WHERE id_usuario = (:id)")
    void updateCaloriaDay3(Integer id, Double day_3);

    @Query("UPDATE Calorias SET day_4 = (:day_4) WHERE id_usuario = (:id)")
    void updateCaloriaDay4(Integer id, Double day_4);

    @Query("UPDATE Calorias SET day_5 = (:day_5) WHERE id_usuario = (:id)")
    void updateCaloriaDay5(Integer id, Double day_5);

    @Query("UPDATE Calorias SET day_6 = (:day_6) WHERE id_usuario = (:id)")
    void updateCaloriaDay6(Integer id, Double day_6);

    @Query("UPDATE Calorias SET day_7 = (:day_7) WHERE id_usuario = (:id)")
    void updateCaloriaDay7(Integer id, Double day_7);



*/
}