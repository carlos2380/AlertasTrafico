package com.alertastrafico.alertatrfico;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alertastrafico.alertatrfico.DataBase.TraficoDB;
import com.alertastrafico.alertatrfico.XML.AdapterXML.DGTIncidenciasAdapterXML;
import com.alertastrafico.alertatrfico.XML.XMLConection;
import com.alertastrafico.alertatrfico.XML.XMLParseController;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TraficoDB traficoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        traficoDB = new TraficoDB(getApplicationContext());
        new DownloadWebpageTask().execute();


    }

    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        XMLConection xmlConection = new XMLConection();
        XMLParseController xmlParseController = new XMLParseController();

        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                xmlConection.conectar(getApplicationContext());
                xmlParseController.parseDGTIncidenciasXMLParser(xmlConection.getResult(), traficoDB);
            } catch (IOException e) {
                 return "Unable to retrieve web page. URL may be invalid.";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        // @Override
        protected void onPostExecute(String result) {
                textView.setText("FINITO");
        }
    }
}
