package com.alertastrafico.alertatrfico.XML.AdapterXML;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Date;

/**
 * Created by carlos on 18/06/2016.
 */
public class DGTIncidenciasAdapterXML {

    public Date fecha_hora;
    public String sistema;

    public String tipo;
    public String autonomia;
    public String provincia;
    public String causa;
    public String poblacion;
    public Date fechahora_ini;
    public String nivel;
    public String carretera;
    public float pk_inicial;
    public float pk_final;
    public String sentido;
    public String hacia;
    public String ref_incidencia;
    public int version_incidencia;
    public float x;
    public float y;

    public DGTIncidenciasAdapterXML() {}
    public DGTIncidenciasAdapterXML(Date fecha_hora, String sistema, String tipo, String autonomia, String provincia,
                                    String causa, String poblacion, Date fechahora_ini, String nivel, String carretera,
                                    float pk_inicial, float pk_final, String sentido, String hacia,
                                    String ref_incidencia, int version_incidencia,
                                    float x, float y, int tipolocalizacion) {

        this.fecha_hora = fecha_hora;
        this.sistema = sistema;
        this.tipo = tipo;
        this.autonomia = autonomia;
        this.provincia = provincia;
        this.causa = causa;
        this.poblacion = poblacion;
        this.fechahora_ini = fechahora_ini;
        this.nivel = nivel;
        this.carretera = carretera;
        this.pk_inicial = pk_inicial;
        this.pk_final = pk_final;
        this.sentido = sentido;
        this.hacia = hacia;
        this.ref_incidencia = ref_incidencia;

        this.version_incidencia = version_incidencia;
        this.x = x;
        this.y = y;
        this.tipolocalizacion = tipolocalizacion;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setFechahora_ini(Date fechahora_ini) {
        this.fechahora_ini = fechahora_ini;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    public void setPk_inicial(float pk_inicial) {
        this.pk_inicial = pk_inicial;
    }

    public void setPk_final(float pk_final) {
        this.pk_final = pk_final;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public void setHacia(String hacia) {
        this.hacia = hacia;
    }

    public void setRef_incidencia(String ref_incidencia) {
        this.ref_incidencia = ref_incidencia;
    }

    public void setVersion_incidencia(int version_incidencia) {
        this.version_incidencia = version_incidencia;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setTipolocalizacion(int tipolocalizacion) {
        this.tipolocalizacion = tipolocalizacion;
    }

    public int tipolocalizacion;



    public Date getFecha_hora() {
        return fecha_hora;
    }

    public String getSistema() {
        return sistema;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCausa() {
        return causa;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public Date getFechahora_ini() {
        return fechahora_ini;
    }

    public String getNivel() {
        return nivel;
    }

    public String getCarretera() {
        return carretera;
    }

    public float getPk_inicial() {
        return pk_inicial;
    }

    public float getPk_final() {
        return pk_final;
    }

    public String getSentido() {
        return sentido;
    }

    public String getHacia() {
        return hacia;
    }

    public String getRef_incidencia() {
        return ref_incidencia;
    }

    public int getVersion_incidencia() {
        return version_incidencia;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getTipolocalizacion() {
        return tipolocalizacion;
    }


}