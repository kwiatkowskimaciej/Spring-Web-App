package com.example.servingwebcontent.database;

public class Fabryka {
    private int nr_fabryki;
    private String nazwa;
    private String e_mail;
    private String nr_konta;
    private String czy_zagraniczny;
    private String odleglosc;
    private int nr_adresu;
    private int nr_zbioru_telefonow;
    private String pierwszy_telefon;

    public Fabryka() {

    }

    public Fabryka(int nr_fabryki, String nazwa, String e_mail, String nr_konta, String czy_zagraniczny, String odleglosc, int nr_adresu, int nr_zbioru_telefonow, String pierwszy_telefon) {
        this.nr_fabryki = nr_fabryki;
        this.nazwa = nazwa;
        this.e_mail = e_mail;
        this.nr_konta = nr_konta;
        this.czy_zagraniczny = czy_zagraniczny;
        this.odleglosc = odleglosc;
        this.nr_adresu = nr_adresu;
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
        this.pierwszy_telefon = pierwszy_telefon;
    }

    public int getNr_fabryki() {
        return nr_fabryki;
    }

    public void setNr_fabryki(int nr_fabryki) {
        this.nr_fabryki = nr_fabryki;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(String nr_konta) {
        this.nr_konta = nr_konta;
    }

    public String getCzy_zagraniczny() {
        return czy_zagraniczny;
    }

    public void setCzy_zagraniczny(String czy_zagraniczny) {
        this.czy_zagraniczny = czy_zagraniczny;
    }

    public String getOdleglosc() {
        return odleglosc;
    }

    public void setOdleglosc(String odleglosc) {
        this.odleglosc = odleglosc;
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

    public String getPierwszy_telefon() {
        return pierwszy_telefon;
    }

    public void setPierwszy_telefon(String pierwszy_telefon) {
        this.pierwszy_telefon = pierwszy_telefon;
    }

    @Override
    public String toString() {
        return "Fabryka{" +
                "nr_fabryki=" + nr_fabryki +
                ", nazwa='" + nazwa + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", nr_konta='" + nr_konta + '\'' +
                ", czy_zagraniczny=" + czy_zagraniczny +
                ", odleglosc='" + odleglosc + '\'' +
                ", nr_adresu=" + nr_adresu +
                ", nr_zbioru_telefonow=" + nr_zbioru_telefonow +
                ", pierwszy_telefon='" + pierwszy_telefon + '\'' +
                '}';
    }
}
