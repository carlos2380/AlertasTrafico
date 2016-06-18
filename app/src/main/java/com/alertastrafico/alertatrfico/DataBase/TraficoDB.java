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

    public void setIncidencia(String tipo, String autonomia, String provincia,
                              String causa, String poblacion, Date fechahora_ini, String nivel, String carretera,
                              float pk_inicial, float pk_final, String sentido, String hacia,
                              String ref_incidencia, int version_incidencia,
                              float x, float y, int tipolocalizacion) {

        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO alertasTrafico (autonomia, provincia, poblacion, inicio, tipo, causa, nivel, carretera, km_inicial, km_final, sentido, hacia, ref, version, corx, cory, tipolocalizacion)  " +
                "VALUES ('"+ autonomia + "', '" + provincia + "', '" + poblacion + "', '" + fechahora_ini + "', '" + tipo + "', '" + causa + "', '" + nivel + "', '" + carretera + "', '" + pk_inicial + "', '" + pk_final
                + "', '" + sentido + "', '" + hacia + "', '" + ref_incidencia + "', '" + version_incidencia + "', '" + x + "', '" + y + "', '" + tipolocalizacion + "');");
    }
}
