package com.example.gourmetfit20;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CaloriasDAO {

    @Insert
    void inserirCaloria(Calorias calorias);

    @Query("UPDATE Calorias SET day_1 = (:day_1) WHERE id_usuario = (:id)")
    void updateCaloriaDay1(Integer id, Double day_1);

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

    @Query("SELECT * FROM Calorias WHERE id_usuario=(:id)")
    Calorias getCaloriaByUserId(Integer id);
}
