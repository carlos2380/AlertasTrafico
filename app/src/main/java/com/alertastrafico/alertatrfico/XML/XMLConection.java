package com.alertastrafico.alertatrfico.XML;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alertastrafico.alertatrfico.MainActivity;
import com.alertastrafico.alertatrfico.XML.AdapterXML.DGTIncidenciasAdapterXML;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by carlos on 18/06/2016.
 */
public class XMLConection {

    private static final String DEBUG_TAG = "HttpExample";
    private InputStream result;
    //Comprovamos que el dispositivo tenga conexiona a internet
    public String conectar(Context context) throws Exception {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            result = downloadUrl("http://www.dgt.es/incidenciasXY.xml");
            return "200 OK";
        } else {
            throw new Exception("No hay conexion!");
        }
    }

    private InputStream downloadUrl(String myurl) throws IOException {
        InputStream stream = null;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(1000000 /* milliseconds */);
            conn.setConnectTimeout(1500000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            return conn.getInputStream();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public InputStream getResult() {
        return result;
    }
}
