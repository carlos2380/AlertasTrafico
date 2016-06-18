package com.alertastrafico.alertatrfico.XML.ParserXML;

import android.util.Xml;

import com.alertastrafico.alertatrfico.XML.AdapterXML.DGTIncidenciasAdapterXML;
import com.alertastrafico.alertatrfico.XML.AdapterXML.DGTIncidenciasAdapterXML.*;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 18/06/2016.
 */
public class DGTIncidenciasXMLParser {

    private static final String ns = null;

    private static ArrayList<DGTIncidenciasAdapterXML> incidencias;

    public DGTIncidenciasXMLParser () {}


    /*Clase para TEST -BORRAR*/
    public ArrayList<DGTIncidenciasAdapterXML> getIncidencias() {
        return incidencias;
    }

    public ArrayList<DGTIncidenciasAdapterXML> parse(InputStream in) throws XmlPullParserException, IOException {
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

    private ArrayList<DGTIncidenciasAdapterXML> readRaiz(XmlPullParser parser) throws XmlPullParserException, IOException {

        incidencias = new ArrayList<>();
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
    private DGTIncidenciasAdapterXML readIncidencia(XmlPullParser parser) throws XmlPullParserException, IOException {

        DGTIncidenciasAdapterXML dgtIncidenciasAdapterXML = new DGTIncidenciasAdapterXML();

        parser.require(XmlPullParser.START_TAG, ns, "incidencia");

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("tipo")) {
                dgtIncidenciasAdapterXML.setTipo(readString(parser, name));
            }/* else if (name.equals("autonomia")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("provincia")) {
                dgtIncidenciasAdapterXML.setProvincia(readString(parser, name));
            } else if (name.equals("causa")) {
                dgtIncidenciasAdapterXML.setCausa(readString(parser, name));
            } else if (name.equals("poblacion")) {
                dgtIncidenciasAdapterXML.setPoblacion(readString(parser, name));
            } else if (name.equals("fechahora_ini")) {
                //dgtIncidenciasAdapterXML.setFechahora_ini(readString(parser, name));
            } else if (name.equals("nivel")) {
                dgtIncidenciasAdapterXML.setNivel(readString(parser, name));
            } else if (name.equals("carretera")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("pk_inicial")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("pk_final")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("sentido")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("hacia")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("ref_incidencia")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("version_incidencia")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("x")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("y")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            } else if (name.equals("tipolocalizacion")) {
                dgtIncidenciasAdapterXML.setAutonomia(readString(parser, name));
            }*/else {
                skip(parser);
            }
        }
        return dgtIncidenciasAdapterXML;
    }
    // Processes title tags in the feed.
    private String readString(XmlPullParser parser, String name) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, name);
        String contentString = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, name);
        return contentString;
    }

    // For the tags title and summary, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }


    //Saltarse tags que no queremos
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
