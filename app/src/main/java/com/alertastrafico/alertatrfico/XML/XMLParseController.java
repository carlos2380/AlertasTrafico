package com.alertastrafico.alertatrfico.XML;

import com.alertastrafico.alertatrfico.DataBase.HelperDB;
import com.alertastrafico.alertatrfico.XML.ParserXML.DGTIncidenciasXMLParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

/**
 * Created by carlos on 18/06/2016.
 */
public class XMLParseController {

    private DGTIncidenciasXMLParser dgtIncidenciasXMLParser;

    public XMLParseController() {
        dgtIncidenciasXMLParser = new DGTIncidenciasXMLParser();
    }

    public void parseDGTIncidenciasXMLParser(InputStream stream, HelperDB helperDB) throws IOException, XmlPullParserException, ParseException {
        dgtIncidenciasXMLParser.parse(stream, helperDB);
    }

    public DGTIncidenciasXMLParser getDgtIncidenciasXMLParser() {
        return dgtIncidenciasXMLParser;
    }
}
