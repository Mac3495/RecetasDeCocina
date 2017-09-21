package com.example.marcelo.recetasdecocina.model;

/**
 * Created by Marcelo on 14/09/2017.
 */

public class TipoComida {

    private int Imagen;
    private String nombre;

    public TipoComida(int imagen, String nombre) {
        Imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
