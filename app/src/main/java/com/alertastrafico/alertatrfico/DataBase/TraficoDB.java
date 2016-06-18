package com.alertastrafico.alertatrfico.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by carlos on 18/06/2016.
 */
public class TraficoDB extends SQLiteOpenHelper {

    public TraficoDB(Context context) {
        super(context, "Trafico", null, 1);
    }
    private int id = 0;
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE alertasTrafico ("+
                "id REAL, " +
                "autonomia TEXT, " +
                "provincia TEXT, " +
                "poblacion TEXT, " +
                "inicio Time, " +
                "tipo TEXT, " +
                "causa TEXT, " +
                "nivel TEXT, " +
                "carretera TEXT, " +
                "kminicial REAL, " +
                "kmfinal REAL, " +
                "sentido TEXT, " +
                "hacia TEXT, " +
                "ref TEXT, " +
                "version REAL, " +
                "corx REAL, " +
                "cory REAL, " +
                "tipolocalizacion REAL, " +
                "PRIMARY KEY (id))");
    }

    @Override    public void onUpgrade(SQLiteDatabase db, int intoldVersion, int newVersion) {
        // En caso de una nueva versión habría que actualizar las tablas
    }

    public void setIncidencia(String tipo, String autonomia, String provincia,
                              String causa, String poblacion, String fechahora_ini, String nivel, String carretera,
                              double pk_inicial, double pk_final, String sentido, String hacia,
                              String ref_incidencia, int version_incidencia,
                              double x, double y, int tipolocalizacion) {

        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO alertasTrafico (id, autonomia, provincia, poblacion, inicio, tipo, causa, nivel, carretera, kminicial, kmfinal, sentido, hacia, ref, version, corx, cory, tipolocalizacion)  " +
                "VALUES ('"+ String.valueOf(id) + "', '" + autonomia + "', '" + provincia + "', '" + poblacion + "', '" + fechahora_ini + "', '" + tipo + "', '" + causa + "', '" + nivel + "', '" + carretera + "', '" + String.valueOf(pk_inicial) + "', '" + String.valueOf(pk_final)
                + "', '" + sentido + "', '" + hacia + "', '" + ref_incidencia + "', '" + String.valueOf(version_incidencia) + "', '" + String.valueOf(x) + "', '" + String.valueOf(y) + "', '" + String.valueOf(tipolocalizacion) + "');");

        ++id;
    }
}
