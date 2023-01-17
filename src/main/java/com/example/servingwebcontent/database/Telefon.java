package com.example.servingwebcontent.database;

public class Telefon {
    private int nr_zbioru_telefonow;
    private String pierwszy_telefon;
    private String drugi_telefon;
    private String trzeci_telefon;

    public Telefon() {

    }

    public Telefon(int nr_zbioru_telefonow, String pierwszy_telefon, String drugi_telefon, String trzeci_telefon) {
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
        this.pierwszy_telefon = pierwszy_telefon;
        this.drugi_telefon = drugi_telefon;
        this.trzeci_telefon = trzeci_telefon;
    }

    public int getNr_zbioru_telefonow() {
        return nr_zbioru_telefonow;
    }

    public void setNr_zbioru_telefonow(int nr_zbioru_telefonow) {
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
    }

    public String getPierwszy_telefon() {
        return pierwszy_telefon;
    }

    public void setPierwszy_telefon(String pierwszy_telefon) {
        this.pierwszy_telefon = pierwszy_telefon;
    }

    public String getDrugi_telefon() {
        return drugi_telefon;
    }

    public void setDrugi_telefon(String drugi_telefon) {
        this.drugi_telefon = drugi_telefon;
    }

    public String getTrzeci_telefon() {
        return trzeci_telefon;
    }

    public void setTrzeci_telefon(String trzeci_telefon) {
        this.trzeci_telefon = trzeci_telefon;
    }

    @Override
    public String toString() {
        return "Telefon{" +
                "nr_zbioru_telefonow=" + nr_zbioru_telefonow +
                ", pierwszy_telefon='" + pierwszy_telefon + '\'' +
                ", drugi_telefon='" + drugi_telefon + '\'' +
                ", trzeci_telefon='" + trzeci_telefon + '\'' +
                '}';
    }
}
