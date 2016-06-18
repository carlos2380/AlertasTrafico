package com.alertastrafico.alertatrfico.XML;

import android.util.Xml;

import com.alertastrafico.alertatrfico.XML.ParserXML.DGTIncidenciasXMLParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;

/**
 * Created by carlos on 18/06/2016.
 */
public class XMLParseController {

    private DGTIncidenciasXMLParser dgtIncidenciasXMLParser;

    public XMLParseController() {
        dgtIncidenciasXMLParser = new DGTIncidenciasXMLParser();
    }

    public void parseDGTIncidenciasXMLParser(InputStream stream) throws IOException, XmlPullParserException, ParseException {
        dgtIncidenciasXMLParser.parse(stream);
    }

    public DGTIncidenciasXMLParser getDgtIncidenciasXMLParser() {
        return dgtIncidenciasXMLParser;
    }
}
