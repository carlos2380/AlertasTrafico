package com.alertastrafico.alertatrfico.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.alertastrafico.alertatrfico.Model.Territorio;
import com.alertastrafico.alertatrfico.R;

import java.util.List;

/**
 * Created by carlos on 19/06/2016.
 */
public class MyCustomAdapterListPoblacion extends ArrayAdapter {
    private List<Territorio> mTerritorio;
    private Context mContext;
    private int mResource;

    public MyCustomAdapterListPoblacion(Context context, List<Territorio> data) {
        super(context, R.layout.custom_list_municipios, data);
        mContext = context;
        mTerritorio = data;
        mResource = R.layout.custom_list_municipios;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(mResource, parent, false);

        TextView tipo = (TextView) rowView.findViewById(R.id.tipoTerritorio);
        TextView nombre = (TextView) rowView.findViewById(R.id.nombreTerritorio);
        TextView padre = (TextView) rowView.findViewById(R.id.territorioPadre);

        Territorio registro = mTerritorio.get(position);
        tipo.setText(registro.getTipo());
        nombre.setText(registro.getNombre());
        padre.setText(registro.getPadre());

        return rowView;
    }
}
