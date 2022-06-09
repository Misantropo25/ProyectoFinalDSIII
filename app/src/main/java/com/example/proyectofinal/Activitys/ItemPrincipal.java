package com.example.proyectofinal.Activitys;

public class ItemPrincipal {
    private String tituloa;
    private String descripciona;
    private int imgresourcea;
    private int imgresourcescamdos;

    public ItemPrincipal(String tituloa, String descripciona, int imgResourcea,int imgresourcescamdos){
        this.tituloa = tituloa;
        this.descripciona = descripciona;
        this.imgresourcea= imgResourcea;
        this.imgresourcescamdos = imgresourcescamdos;
    }

    public String getTituloa(){
        return tituloa;
    }
    public String getDescripciona(){
        return descripciona;
    }
    public  int getImgresourcea(){
        return imgresourcea;
    }
    public int getImgresourcescamdos(){return imgresourcescamdos;}
}
