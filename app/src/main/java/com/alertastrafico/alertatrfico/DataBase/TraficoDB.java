package com.alertastrafico.alertatrfico.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carlos on 18/06/2016.
 */
public class TraficoDB extends SQLiteOpenHelper {

    public TraficoDB(Context context) {
        super(context, "Trafico", null, 1);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE alertasTrafico ("+
                "autonomia TEXT, " +
                "provincia TEXT, " +
                "poblacion TEXT, " +
                "inicio Time, " +
                "tipo TEXT, " +
                "causa TEXT, " +
                "nivel TEXT, " +
                "carretera TEXT, " +
                "km_inicial REAL, " +
                "km_final REAL, " +
                "sentido TEXT, " +
                "hacia TEXT, " +
                "ref TEXT, " +
                "version REAL, " +
                "corx REAL, " +
                "cory REAL, " +
                "tipolocalizacion REAL, " +
                "PRIMARY KEY (ref, version))");
    }

    @Override    public void onUpgrade(SQLiteDatabase db, int intoldVersion, int newVersion) {
        // En caso de una nueva versión habría que actualizar las tablas
    }
}