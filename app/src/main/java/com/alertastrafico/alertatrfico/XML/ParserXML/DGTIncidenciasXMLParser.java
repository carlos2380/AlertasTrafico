package com.alertastrafico.alertatrfico.XML.ParserXML;

import android.util.Xml;

import com.alertastrafico.alertatrfico.XML.AdapterXML.DGTIncidenciasAdapterXML;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static com.alertastrafico.alertatrfico.Utils.UtilsJava.stringToDate;
import static com.alertastrafico.alertatrfico.Utils.UtilsXML.readString;
import static com.alertastrafico.alertatrfico.Utils.UtilsXML.skip;

/**
 * Created by carlos on 18/06/2016.
 */
public class DGTIncidenciasXMLParser {

    private static final String ns = null;

    private static ArrayList<DGTIncidenciasAdapterXML> incidencias;

    public DGTIncidenciasXMLParser () {
        incidencias = new ArrayList<>();
    }


    /*Clase para TEST -BORRAR*/
    public ArrayList<DGTIncidenciasAdapterXML> getIncidencias() {
        return incidencias;
    }

    public ArrayList<DGTIncidenciasAdapterXML> parse(InputStream in) throws XmlPullParserException, IOException, ParseException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readRaiz(parser);
        } finally {
            in.close();
        }
    }

    private ArrayList<DGTIncidenciasAdapterXML> readRaiz(XmlPullParser parser) throws XmlPullParserException, IOException, ParseException {


        parser.require(XmlPullParser.START_TAG, ns, "raiz");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("incidencia")) {
                this.incidencias.add(readIncidencia(parser));
            } else {
                skip(parser);
            }
        }
        return incidencias;
    }

    // Parses the contents of an entry. If it encounters a title, summary, or link tag, hands them off
    // to their respective "read" methods for processing. Otherwise, skips the tag.
    private DGTIncidenciasAdapterXML readIncidencia(XmlPullParser parser) throws XmlPullParserException, IOException, ParseException {

        DGTIncidenciasAdapterXML dgtIncidenciasAdapterXML = new DGTIncidenciasAdapterXML();

        parser.require(XmlPullParser.START_TAG, ns, "incidencia");

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("tipo")) {
                dgtIncidenciasAdapterXML.setTipo(readString(parser, name, ns));
            } else if (name.equals("autonomia")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name, ns));
            } else if (name.equals("provincia")) {
                dgtIncidenciasAdapterXML.setProvincia(readString(parser, name, ns));
            } else if (name.equals("causa")) {
                dgtIncidenciasAdapterXML.setCausa(readString(parser, name, ns));
            } else if (name.equals("poblacion")) {
                dgtIncidenciasAdapterXML.setPoblacion(readString(parser, name, ns));
            } else if (name.equals("fechahora_ini")) {
                dgtIncidenciasAdapterXML.setFechahora_ini(readString(parser, name, ns));
            } else if (name.equals("nivel")) {
                dgtIncidenciasAdapterXML.setNivel(readString(parser, name, ns));
            } else if (name.equals("carretera")) {
                dgtIncidenciasAdapterXML.setCarretera(readString(parser, name, ns));
            } else if (name.equals("pk_inicial")) {
                dgtIncidenciasAdapterXML.setPk_inicial(readString(parser, name, ns));
            } else if (name.equals("pk_final")) {
                dgtIncidenciasAdapterXML.setPk_final(readString(parser, name, ns));
            } else if (name.equals("sentido")) {
                dgtIncidenciasAdapterXML.setSentido(readString(parser, name, ns));
            } else if (name.equals("hacia")) {
                dgtIncidenciasAdapterXML.setHacia(readString(parser, name, ns));
            } else if (name.equals("ref_incidencia")) {
                dgtIncidenciasAdapterXML.setRef_incidencia(readString(parser, name, ns));
            } else if (name.equals("version_incidencia")) {
                dgtIncidenciasAdapterXML.setVersion_incidencia(readString(parser, name, ns));
            } else if (name.equals("x")) {
                dgtIncidenciasAdapterXML.setX(readString(parser, name, ns));
            } else if (name.equals("y")) {
                dgtIncidenciasAdapterXML.setY(readString(parser, name, ns));
            } else if (name.equals("tipolocalizacion")) {
                dgtIncidenciasAdapterXML.setTipolocalizacion(readString(parser, name, ns));
            } else {
                skip(parser);
            }
        }
        return dgtIncidenciasAdapterXML;
    }

}
