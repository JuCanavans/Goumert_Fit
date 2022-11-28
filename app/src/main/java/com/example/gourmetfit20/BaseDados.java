package com.example.gourmetfit20;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;





@Database(entities = {Usuario.class, Calorias.class, Avaliacao.class,Perfil.class},version = 9, exportSchema = false)
public  abstract class BaseDados extends RoomDatabase {
    // CRIANDO A INSTANCIA
    private static BaseDados database;
    // CRIANDO O METODO DE ACESSO A CLASSE DAO Usuario
    public abstract UsuarioDAO UsuarioDAO();
    // CRIANDO O METODO DE ACESSO A CLASSE DAO Calorias
    public abstract CaloriasDAO caloriasDAO();
    // CRIANDO O METODO DE ACESSO A CLASSE DAO Avaliacao
    public abstract AvaliacaoDAO avaliacaoDAO();
    // CRIANDO O METODO DE ACESSO A CLASSE DAO Perfil
    public abstract PerfilDAO perfilDAO();
    // Modelo Singleton
    public static BaseDados getInstance(Context context) {
        if (database == null) {
            synchronized (BaseDados.class) {
                if (database == null) {
                    // Cria o banco de dados
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            BaseDados.class,"BancoGourmetFit").allowMainThreadQueries().fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return database;
    }
}