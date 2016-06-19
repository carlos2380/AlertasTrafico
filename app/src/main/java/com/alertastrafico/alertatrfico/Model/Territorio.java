package com.alertastrafico.alertatrfico.Model;

/**
 * Created by carlos on 19/06/2016.
 */
public class Territorio {
    private String tipo;
    private String nombre;
    private String padre;

    public Territorio() {}
    public Territorio(String tipo, String nombre, String padre) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.padre = padre;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
