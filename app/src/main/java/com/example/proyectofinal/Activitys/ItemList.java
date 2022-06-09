package com.example.proyectofinal.Activitys;

public class ItemList {

    private String titulo;
    private String descripcion;
    private int imgResource;
    private int imgresourcescam;


    public ItemList(String titulo, String descripcion, int imgResource, int imgresourcescam){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgResource = imgResource;
        this.imgresourcescam = imgresourcescam;
    }
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getimgResource() {
        return imgResource;
    }

    public int getImgresourcescam(){return imgresourcescam;}
}

