package com.alertastrafico.alertatrfico;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alertastrafico.alertatrfico.Adapters.MyCustomAdapterListPoblacion;
import com.alertastrafico.alertatrfico.DataBase.HelperDB;
import com.alertastrafico.alertatrfico.Model.Territorio;
import com.alertastrafico.alertatrfico.XML.XMLConection;
import com.alertastrafico.alertatrfico.XML.XMLParseController;

import java.io.IOException;
import java.util.List;

import static com.alertastrafico.alertatrfico.Utils.UtilsJava.StringForDB;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private HelperDB helperDB;
    private EditText editText;
    private ListView lvTerritorios;

    private MyCustomAdapterListPoblacion adapterListPoblacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        editText = (EditText) findViewById(R.id.editText);
        helperDB = new HelperDB(getApplicationContext());
        lvTerritorios = (ListView) findViewById(R.id.listView) ;
        new DownloadWebpageTask().execute();
        loadListExpandable();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                textView.setText(editText.getText().toString());
                String content = editText.getText().toString();
                new LoadAdapter().execute(content);
                /*//data = StringForDB(content[0]);
                List<Territorio> territorios = helperDB.getTerritorios(content);
                adapterListPoblacion = new MyCustomAdapterListPoblacion(
                        getApplicationContext(),
                        territorios);
                lvTerritorios.setAdapter(adapterListPoblacion);*/
            }
        });



        lvTerritorios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Territorio selectTerritorio = (Territorio) lvTerritorios.getItemAtPosition(position);

                if(selectTerritorio.getTipo().equals("Autonomía")){
                    helperDB.selectAutonomia(selectTerritorio.getNombre());
                }
                new LoadAdapter().execute("");
                Toast savedToast = Toast.makeText(getApplicationContext(),
                        "Territorio > " + selectTerritorio.getNombre(), Toast.LENGTH_SHORT);
                savedToast.show();

            }
        });



    }

    private void loadListExpandable() {

    }
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        XMLConection xmlConection = new XMLConection();
        XMLParseController xmlParseController = new XMLParseController();

        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                xmlConection.conectar(getApplicationContext());
                xmlParseController.parseDGTIncidenciasXMLParser(xmlConection.getResult(), helperDB);
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

    private class LoadAdapter extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... content) {

            String data;
            data = StringForDB(content[0]);
            List<Territorio> territorios = helperDB.getTerritorios(data);
            adapterListPoblacion = new MyCustomAdapterListPoblacion(
                    getApplicationContext(),
                    territorios);


            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            lvTerritorios.setAdapter(adapterListPoblacion);
        }
    }

}
