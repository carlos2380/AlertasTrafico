package com.alertastrafico.alertatrfico;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alertastrafico.alertatrfico.XML.AdapterXML.DGTIncidenciasAdapterXML;
import com.alertastrafico.alertatrfico.XML.XMLConection;
import com.alertastrafico.alertatrfico.XML.XMLParseController;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
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
                xmlParseController.parseDGTIncidenciasXMLParser(xmlConection.getResult());
            } catch (IOException e) {
                 return "Unable to retrieve web page. URL may be invalid.";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

                ArrayList<DGTIncidenciasAdapterXML> incis = xmlParseController.getDgtIncidenciasXMLParser().getIncidencias();
                String s = "";
                for (int i = 0; i < incis.size(); ++i){
                    s += incis.get(i).getTipo() + " " + incis.get(i).getAutonomia()+ " " + incis.get(i).getProvincia()+ " " + incis.get(i).getCausa()+ " " + incis.get(i).getPoblacion()+ " " +incis.get(i).getFechahora_ini()
                            + " " +incis.get(i).getNivel()+ " " +incis.get(i).getCarretera()+ " " +incis.get(i).getPk_inicial()+ " " +incis.get(i).getPk_final()+ " " +incis.get(i).getSentido()+ " HACIAAA-> " +incis.get(i).getHacia()+ " <- " +incis.get(i).getRef_incidencia()
                            + " " +incis.get(i).getVersion_incidencia()+ " " +incis.get(i).getX()+ " " +incis.get(i).getY()+ " " +incis.get(i).getTipolocalizacion()+ "\n\n";
                }
                textView.setText(s);
        }
    }
}
