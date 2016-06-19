package com.alertastrafico.alertatrfico.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by carlos on 18/06/2016.
 */
public class UtilsJava {

    /* Dado una fecha en string y un formato de
    SimpleDateFormat devuelve Date*/
    static public Date stringToDate(String fecha, String formato) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        Date date = formatter.parse(fecha);
        return date;
    }

    static public String StringForDB(String str){
        // Cadena de caracteres original a sustituir.
        String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜ QWERTYUIOPASDFGHJKLÑÇZXCVBNM";
        // Cadena de caracteres ASCII que reemplazarán los originales.
        String modificacion = "aaaeeeiiiooouuunAAAEEEIIIOOOUUU%qwertyuiopasdfghjklñçzxcvbnm";
        String salida = str;
        for (int i=0; i<original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            salida = salida.replace(original.charAt(i), modificacion.charAt(i));
        }//for i
        return salida;
    }


}
