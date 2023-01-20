package com.example.servingwebcontent.database;

public class Klient {
    private int nr_klienta;
    private String imie;
    private String nazwisko;
    private String plec;
    private String nr_konta;
    private String e_mail;
    private Integer nr_adresu;
    private Integer nr_zbioru_telefonow;
    private int nr_salonu;

    public Klient() {

    }

    public Klient(int nr_klienta, String imie, String nazwisko, String plec, String nr_konta, String e_mail, Integer nr_adresu, Integer nr_zbioru_telefonow, int nr_salonu) {
        this.nr_klienta = nr_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.nr_konta = nr_konta;
        this.e_mail = e_mail;
        this.nr_adresu = nr_adresu;
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
        this.nr_salonu = nr_salonu;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(String nr_konta) {
        this.nr_konta = nr_konta;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Integer getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(Integer nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public Integer getNr_zbioru_telefonow() {
        return nr_zbioru_telefonow;
    }

    public void setNr_zbioru_telefonow(Integer nr_zbioru_telefonow) {
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
    }

    public int getNr_salonu() {
        return nr_salonu;
    }

    public void setNr_salonu(int nr_salonu) {
        this.nr_salonu = nr_salonu;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nr_klienta=" + nr_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec=" + plec +
                ", nr_konta='" + nr_konta + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", nr_adresu='" + nr_adresu + '\'' +
                ", nr_zbioru_telefonow='" + nr_zbioru_telefonow + '\'' +
                ", nr_salonu='" + nr_salonu + '\'' +
                '}';
    }
}
