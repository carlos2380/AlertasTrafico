package com.alertastrafico.alertatrfico;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.alertastrafico.alertatrfico.DataBase.HelperDB;
import com.alertastrafico.alertatrfico.XML.XMLConection;
import com.alertastrafico.alertatrfico.XML.XMLParseController;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private HelperDB helperDB;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        editText = (EditText) findViewById(R.id.editText);
        helperDB = new HelperDB(getApplicationContext());
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
}
