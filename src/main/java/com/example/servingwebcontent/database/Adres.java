package com.example.servingwebcontent.database;

public class Adres {
    private int nr_adresu;
    private String panstwo;
    private String kod_pocztowy;
    private String rejon;
    private String miejscowosc;
    private String ulica;
    private String numer;
    private Integer numer_lokalu;

    public Adres() {

    }

    public Adres(int nr_adresu, String panstwo, String kod_pocztowy, String rejon, String miejscowosc, String ulica, String numer, Integer numer_lokalu) {
        this.nr_adresu = nr_adresu;
        this.panstwo = panstwo;
        this.kod_pocztowy = kod_pocztowy;
        this.rejon = rejon;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.numer = numer;
        this.numer_lokalu = numer_lokalu;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public String getPanstwo() {
        return panstwo;
    }

    public void setPanstwo(String panstwo) {
        this.panstwo = panstwo;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getRejon() {
        return rejon;
    }

    public void setRejon(String rejon) {
        this.rejon = rejon;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public Integer getNumer_lokalu() {
        return numer_lokalu;
    }

    public void setNumer_lokalu(Integer numer_lokalu) {
        this.numer_lokalu = numer_lokalu;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nr_adresu=" + nr_adresu +
                ", panstwo='" + panstwo + '\'' +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                ", rejon='" + rejon + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer='" + numer + '\'' +
                ", numer_lokalu='" + numer_lokalu + '\'' +
                '}';
    }
}
