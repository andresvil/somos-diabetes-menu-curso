package com.example.andresvil.menucurso;

/**
 * Created by andresvil on 3/9/16.
 */
public class Modulo {
    private int img_rsc;
    private String modulo;
    private String nombre_capitulo;

    // Constructor
    public Modulo(int img_rsc, String modulo, String nombre_capitulo) {
        this.img_rsc = img_rsc;
        this.modulo = modulo;
        this.nombre_capitulo = nombre_capitulo;
    }

    // Getters & Setters
    public int getImg_rsc() {
        return img_rsc;
    }

    public String getModulo() {
        return modulo;
    }

    public String getNombre_capitulo() {
        return nombre_capitulo;
    }

    public void setImg_rsc(int img_rsc) {
        this.img_rsc = img_rsc;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public void setNombre_capitulo(String nombre_capitulo) {
        this.nombre_capitulo = nombre_capitulo;
    }
}
