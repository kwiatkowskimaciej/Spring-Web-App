package com.example.servingwebcontent.database;

import java.util.Date;

public class Samochod {
    private int nr_samochodu;
    private String vin;
    private Date rok_produkcji = new Date();
    private String typ_nadwozia;
    private char rodzaj_silnika;
    private String typ_napedu;
    private int moc;
    private int ilosc_osob;
    private int poj_bagaznika;
    private String nr_rejestracyjny;
    private String kolor;
    private String cena;
    private int nr_fabryki;
    private int nr_salonu;
    private String nr_klienta;
    private int nr_modelu;

    private String model;

    public Samochod() {
    }

    public Samochod(int nr_samochodu, String vin, Date rok_produkcji, String typ_nadwozia, char rodzaj_silnika, String typ_napedu, int moc, int ilosc_osob, int poj_bagaznika, String nr_rejestracyjny, String kolor, String cena, int nr_fabryki, int nr_salonu, String nr_klienta, int nr_modelu, String model) {
        this.nr_samochodu = nr_samochodu;
        this.vin = vin;
        this.rok_produkcji = rok_produkcji;
        this.typ_nadwozia = typ_nadwozia;
        this.rodzaj_silnika = rodzaj_silnika;
        this.typ_napedu = typ_napedu;
        this.moc = moc;
        this.ilosc_osob = ilosc_osob;
        this.poj_bagaznika = poj_bagaznika;
        this.nr_rejestracyjny = nr_rejestracyjny;
        this.kolor = kolor;
        this.cena = cena;
        this.nr_fabryki = nr_fabryki;
        this.nr_salonu = nr_salonu;
        this.nr_klienta = nr_klienta;
        this.nr_modelu = nr_modelu;
        this.model = model;
    }



    public int getNr_samochodu() {
        return nr_samochodu;
    }

    public void setNr_samochodu(int nr_samochodu) {
        this.nr_samochodu = nr_samochodu;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(Date rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public String getTyp_nadwozia() {
        return typ_nadwozia;
    }

    public void setTyp_nadwozia(String typ_nadwozia) {
        this.typ_nadwozia = typ_nadwozia;
    }

    public char getRodzaj_silnika() {
        return rodzaj_silnika;
    }

    public void setRodzaj_silnika(char rodzaj_silnika) {
        this.rodzaj_silnika = rodzaj_silnika;
    }

    public String getTyp_napedu() {
        return typ_napedu;
    }

    public void setTyp_napedu(String typ_napedu) {
        this.typ_napedu = typ_napedu;
    }

    public int getMoc() {
        return moc;
    }

    public void setMoc(int moc) {
        this.moc = moc;
    }

    public int getIlosc_osob() {
        return ilosc_osob;
    }

    public void setIlosc_osob(int ilosc_osob) {
        this.ilosc_osob = ilosc_osob;
    }

    public int getPoj_bagaznika() {
        return poj_bagaznika;
    }

    public void setPoj_bagaznika(int poj_bagaznika) {
        this.poj_bagaznika = poj_bagaznika;
    }

    public String getNr_rejestracyjny() {
        return nr_rejestracyjny;
    }

    public void setNr_rejestracyjny(String nr_rejestracyjny) {
        this.nr_rejestracyjny = nr_rejestracyjny;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public int getNr_fabryki() {
        return nr_fabryki;
    }

    public void setNr_fabryki(int nr_fabryki) {
        this.nr_fabryki = nr_fabryki;
    }

    public int getNr_salonu() {
        return nr_salonu;
    }

    public void setNr_salonu(int nr_salonu) {
        this.nr_salonu = nr_salonu;
    }

    public String getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(String nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public int getNr_modelu() {
        return nr_modelu;
    }

    public void setNr_modelu(int nr_modelu) {
        this.nr_modelu = nr_modelu;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "nr_samochodu=" + nr_samochodu +
                ", vin='" + vin + '\'' +
                ", rok_produkcji='" + rok_produkcji + '\'' +
                ", typ_nadwozia='" + typ_nadwozia + '\'' +
                ", rodzaj_silnika=" + rodzaj_silnika +
                ", typ_napedu='" + typ_napedu + '\'' +
                ", moc=" + moc +
                ", ilosc_osob=" + ilosc_osob +
                ", poj_bagaznika=" + poj_bagaznika +
                ", nr_rejestracyjny='" + nr_rejestracyjny + '\'' +
                ", kolor='" + kolor + '\'' +
                ", cena='" + cena + '\'' +
                ", nr_fabryki=" + nr_fabryki +
                ", nr_salonu=" + nr_salonu +
                ", nr_klienta='" + nr_klienta + '\'' +
                ", nr_modelu=" + nr_modelu +
                ", model='" + model + '\'' +
                '}';
    }
}
