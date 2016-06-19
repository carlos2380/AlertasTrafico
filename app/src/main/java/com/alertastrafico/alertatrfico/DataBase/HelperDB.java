package com.alertastrafico.alertatrfico.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alertastrafico.alertatrfico.Model.Territorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by carlos on 18/06/2016.
 */
public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(Context context) {
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

        db.execSQL("CREATE TABLE poblaciones (autonomia TEXT, autonomia_simple TEXT, provincia TEXT, provincia_simple TEXT, poblacion TEXT, poblacion_simple TEXT)");

        addProvincias(db);
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

    private void addProvincias(SQLiteDatabase db) {
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                    "VALUES ('Andalucía', 'andalucia', 'Almería', 'almeria');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Andalucía', 'andalucia', 'Granada', 'granada');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Andalucía', 'andalucia', 'Córdoba', 'cordoba');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Andalucía', 'andalucia', 'Jaén', 'jaen');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Andalucía', 'andalucia', 'Sevilla', 'sevilla');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Andalucía', 'andalucia', 'Málaga', 'malaga');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Andalucía', 'andalucia', 'Cádiz', 'cadiz');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Andalucía', 'andalucia', 'Huelva', 'huelva');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Aragón', 'aragon', 'Huesca', 'huesca');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Aragón', 'aragon', 'Zaragoza', 'zaragoza');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Aragón', 'aragon', 'Teruel', 'teruel');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Baleares', 'baleares', 'Baleares', 'baleares');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Canarias', 'canarias', 'Las Palmas de Gran Canaria', 'gran canaria');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Canarias', 'canaria', 'Fuenteventura', 'fuenteventura');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Canarias', 'canarias', 'Lanzarote', 'lanzarote');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Cantabria', 'cantabria', 'Santander', 'santander');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla la Mancha', 'castilla%mancha', 'Toledo', 'toledo');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla la Mancha', 'castilla%mancha', 'Ciuidad Real', 'cudad%real');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla la Mancha', 'castilla%mancha', 'Cuenca', 'cuenca');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla la Mancha', 'castilla%mancha', 'Guadalajara', 'guadalajara');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla la Mancha', 'castilla%la%mancha', 'Albacete', 'albacete');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'León', 'leon');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Palencia', 'palencia');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Salamanca', 'salamanca');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Burgos', 'burgos');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Zamora', 'zamora');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Valladolid', 'valladolid');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Soria', 'soria');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Segovia', 'segovia');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Castilla y Leon', 'castilla%y%leon', 'Ávila', 'avila');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Cataluña', 'cataluña', 'Barcelona', 'barcelona');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Cataluña', 'cataluña', 'Lérida', 'lerida');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Cataluña', 'cataluña', 'Gerona', 'gerona');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Cataluña', 'cataluña', 'Tarragona', 'tarragona');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Extremadura', 'extremadura', 'Cáceres', 'caceres');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Extremadura', 'extremadura', 'Badajoz', 'badajoz');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Galicia', 'galicia', 'La Coruña', 'coruña');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Galicia', 'galicia', 'Lugo', 'lugo');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Galicia', 'galicia', 'Orense', 'orense');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Galicia', 'galicia', 'Pontevedra', 'pontevedra');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('La Riojo', 'rioja', 'La Rioja', 'rioja');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Comunidad de Madrid', 'madrid', 'Madrid', 'madrid');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Navarra', 'navarra', 'Pamplona', 'pamplona');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('País Vasco', 'pais%vasco', 'Álava', 'alava');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('País Vasco', 'pais%vasco', 'Guipúzcoa', 'guipuzcoa');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('País Vasco', 'pais%vasco', 'Vizcaya ', 'vizcaya ');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Región de Murcia', 'region%murcia', 'Murcia', 'murcia');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Comunidad Valenciana', 'comunidad%valenciana', 'Castellón', 'castellon');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Comunidad Valenciana', 'comunidad%valenciana', 'Valencia', 'valencia');");
        db.execSQL("INSERT INTO poblaciones (autonomia, autonomia_simple, provincia, provincia_simple)" +
                "VALUES ('Comunidad Valenciana', 'comunidad%valenciana', 'Alicante', 'alicante');");
    }

    public List<Territorio> getTerritorios(String entrada) {

        List<Territorio> territorios = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT DISTINCT  autonomia FROM poblaciones WHERE autonomia_simple LIKE '%" + entrada + "%';";

        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            Territorio territorio = new Territorio();
            String tipo = "Autonomía";
            String nombre = cursor.getString(0);
            String padre = " ";
            territorio.setTipo(tipo);
            territorio.setNombre(nombre);
            territorio.setPadre(padre);
            territorios.add(territorio);
        }
        cursor.close();

        String query2 = "SELECT DISTINCT  autonomia, provincia FROM poblaciones WHERE provincia_simple LIKE '%" + entrada + "%';";

        Cursor cursor2 = db.rawQuery(query2,null);
        while (cursor2.moveToNext()){
            Territorio territorio = new Territorio();
            String tipo = "Provincia";
            String nombre = cursor2.getString(1);
            String padre = cursor2.getString(0);;
            territorio.setTipo(tipo);
            territorio.setNombre(nombre);
            territorio.setPadre(padre);
            territorios.add(territorio);
        }
        cursor2.close();

        String query3 = "SELECT DISTINCT  provincia, poblacion FROM poblaciones WHERE poblacion_simple LIKE '%" + entrada + "%';";

        Cursor cursor3 = db.rawQuery(query3,null);
        while (cursor3.moveToNext()){
            Territorio territorio = new Territorio();
            String tipo = "Municipio";
            String nombre = cursor3.getString(1);
            String padre = cursor3.getString(0);;
            territorio.setTipo(tipo);
            territorio.setNombre(nombre);
            territorio.setPadre(padre);
            territorios.add(territorio);
        }
        cursor3.close();

        db.close();
        return territorios;
    }

}
