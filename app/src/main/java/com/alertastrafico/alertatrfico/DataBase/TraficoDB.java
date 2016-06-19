package com.alertastrafico.alertatrfico.DataBase;

import android.content.ContentValues;
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
                "id INTEGER PRIMARY KEY, " +
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
                "tipolocalizacion INTEGER)");
    }

    @Override    public void onUpgrade(SQLiteDatabase db, int intoldVersion, int newVersion) {
        // En caso de una nueva versión habría que actualizar las tablas
    }

    public void setIncidencia(String tipo, String autonomia, String provincia,
                              String causa, String poblacion, String fechahora_ini, String nivel, String carretera,
                              String pk_inicial, String pk_final, String sentido, String hacia,
                              String ref_incidencia, String version_incidencia,
                              String x, String y, String tipolocalizacion) {

        SQLiteDatabase db = getWritableDatabase();
       /* db.execSQL("INSERT INTO alertasTrafico (id, autonomia, provincia, poblacion, inicio, tipo, causa, nivel, carretera, kminicial, kmfinal, sentido, hacia, ref, version, corx, cory, tipolocalizacion)  " +
                "VALUES ('"+ String.valueOf(id) + "', '" + autonomia + "', '" + provincia + "', '" + poblacion + "', '" + fechahora_ini + "', '" + tipo + "', '" + causa + "', '" + nivel + "', '" + carretera + "', '" + String.valueOf(pk_inicial) + "', '" + String.valueOf(pk_final)
                + "', '" + sentido + "', '" + hacia + "', '" + ref_incidencia + "', '" + String.valueOf(version_incidencia) + "', '" + String.valueOf(x) + "', '" + String.valueOf(y) + "', '" + String.valueOf(tipolocalizacion) + "');");

        ++id;*/
        ContentValues contentValues = new ContentValues();
        contentValues.put("autonomia", autonomia);
        contentValues.put("provincia", provincia);
        contentValues.put("poblacion", poblacion);
        contentValues.put("inicio", fechahora_ini);
        contentValues.put("tipo", tipo);
        contentValues.put("causa", causa);
        contentValues.put("autonomia", provincia);
        contentValues.put("nivel", nivel);
        contentValues.put("carretera", carretera);
        contentValues.put("kminicial", pk_inicial);
        contentValues.put("kmfinal", pk_final);
        contentValues.put("sentido", sentido);
        contentValues.put("hacia", hacia);
        contentValues.put("ref", ref_incidencia);
        contentValues.put("version", version_incidencia);
        contentValues.put("corx", x);
        contentValues.put("cory", y);
        contentValues.put("tipolocalizacion", tipolocalizacion);
        contentValues.put("autonomia", autonomia);
        db.insert("alertasTrafico", null, contentValues);
    }
}
