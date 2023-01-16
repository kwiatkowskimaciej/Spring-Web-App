package com.example.servingwebcontent.database;

public class Serwis {
    private int nr_serwisu;
    private String nazwa;
    private int liczba_stanowisk;
    private int nr_salonu;
    private int nr_adresu;
    private int nr_zbioru_telefonow;

    public Serwis() {
    }

    public Serwis(int nr_serwisu, String nazwa, int liczba_stanowisk, int nr_salonu, int nr_adresu, int nr_zbioru_telefonow) {
        this.nr_serwisu = nr_serwisu;
        this.nazwa = nazwa;
        this.liczba_stanowisk = liczba_stanowisk;
        this.nr_salonu = nr_salonu;
        this.nr_adresu = nr_adresu;
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
    }

    public int getNr_serwisu() {
        return nr_serwisu;
    }

    public void setNr_serwisu(int nr_serwisu) {
        this.nr_serwisu = nr_serwisu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLiczba_stanowisk() {
        return liczba_stanowisk;
    }

    public void setLiczba_stanowisk(int liczba_stanowisk) {
        this.liczba_stanowisk = liczba_stanowisk;
    }

    public int getNr_salonu() {
        return nr_salonu;
    }

    public void setNr_salonu(int nr_salonu) {
        this.nr_salonu = nr_salonu;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public int getNr_zbioru_telefonow() {
        return nr_zbioru_telefonow;
    }

    public void setNr_zbioru_telefonow(int nr_zbioru_telefonow) {
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
    }

    @Override
    public String toString() {
        return "Serwis{" +
                "nr_serwisu=" + nr_serwisu +
                ", nazwa='" + nazwa + '\'' +
                ", liczba_stanowisk=" + liczba_stanowisk +
                ", nr_salonu=" + nr_salonu +
                ", nr_adresu=" + nr_adresu +
                ", nr_zbioru_telefonow=" + nr_zbioru_telefonow +
                '}';
    }
}
