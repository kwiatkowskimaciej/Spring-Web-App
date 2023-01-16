package com.example.servingwebcontent.database;

import java.util.Date;

public class Salon {
    private int nr_salonu;
    private String nazwa;
    private Date data_zalozenia;
    private int nr_adresu;
    private int nr_zbioru_telefonow;

    public Salon() {
    }
    public Salon(int nr_salonu, String nazwa, Date data_zalozenia, int nr_adresu, int nr_zbioru_telefonow) {
        this.nr_salonu = nr_salonu;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.nr_adresu = nr_adresu;
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
    }

    public int getNr_salonu() {
        return nr_salonu;
    }

    public void setNr_salonu(int nr_salonu) {
        this.nr_salonu = nr_salonu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Date data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
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
        return "Salon{" +
                "nr_salonu=" + nr_salonu +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia='" + data_zalozenia + '\'' +
                ", nr_adresu=" + nr_adresu +
                ", nr_zbioru_telefonow=" + nr_zbioru_telefonow +
                '}';
    }
}
