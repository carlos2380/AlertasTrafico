package com.alertastrafico.alertatrfico.Utils;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by carlos on 18/06/2016.
 */
public class UtilsXML {

    // Processes title tags in the feed.
    static public String readString(XmlPullParser parser, String name, String ns) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, name);
        String contentString = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, name);
        return contentString;
    }

    // For the tags title and summary, extracts their text values.
    static public String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }


    //Saltarse tags que no queremos
    static public void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
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
