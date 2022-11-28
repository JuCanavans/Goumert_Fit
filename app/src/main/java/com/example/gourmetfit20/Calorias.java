package com.example.gourmetfit20;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Calorias implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id_usuario")
    private Integer id_tabela_caloria_que_é_o_mesmo_id_do_usuário;
    private Double day_1 = 0.0;
    private Double day_2 = 0.0;
    private Double day_3 = 0.0;
    private Double day_4 = 0.0;
    private Double day_5 = 0.0;
    private Double day_6 = 0.0;
    private Double day_7 = 0.0;

    public Integer getId_tabela_caloria_que_é_o_mesmo_id_do_usuário() {
        return id_tabela_caloria_que_é_o_mesmo_id_do_usuário;
    }

    public void setId_tabela_caloria_que_é_o_mesmo_id_do_usuário(Integer id_tabela_caloria_que_é_o_mesmo_id_do_usuário) {
        this.id_tabela_caloria_que_é_o_mesmo_id_do_usuário = id_tabela_caloria_que_é_o_mesmo_id_do_usuário;
    }

    public Double getDay_1() {
        return day_1;
    }

    public void setDay_1(Double day_1) {
        this.day_1 = day_1;
    }

    public Double getDay_2() {
        return day_2;
    }

    public void setDay_2(Double day_2) {
        this.day_2 = day_2;
    }

    public Double getDay_3() {
        return day_3;
    }

    public void setDay_3(Double day_3) {
        this.day_3 = day_3;
    }

    public Double getDay_4() {
        return day_4;
    }

    public void setDay_4(Double day_4) {
        this.day_4 = day_4;
    }

    public Double getDay_5() {
        return day_5;
    }

    public void setDay_5(Double day_5) {
        this.day_5 = day_5;
    }

    public Double getDay_6() {
        return day_6;
    }

    public void setDay_6(Double day_6) {
        this.day_6 = day_6;
    }

    public Double getDay_7() {
        return day_7;
    }

    public void setDay_7(Double day_7) {
        this.day_7 = day_7;
    }


}
