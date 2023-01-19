package com.example.servingwebcontent.database;

public class Firma {
    private int nr_firmy;
    private String nazwa;
    private String nip;
    private String regon;
    private String krs;
    private String nr_konta;
    private String e_mail;
    private int nr_klienta;
    private String nr_adresu;
    private String nr_zbioru_telefonow;

    public Firma() {

    }

    public Firma(int nr_firmy, String nazwa, String nip, String regon, String krs, String nr_konta, String e_mail, int nr_klienta, String nr_adresu, String nr_zbioru_telefonow) {
        this.nr_firmy = nr_firmy;
        this.nazwa = nazwa;
        this.nip = nip;
        this.regon = regon;
        this.krs = krs;
        this.nr_konta = nr_konta;
        this.e_mail = e_mail;
        this.nr_klienta = nr_klienta;
        this.nr_adresu = nr_adresu;
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
    }

    public int getNr_firmy() {
        return nr_firmy;
    }

    public void setNr_firmy(int nr_firmy) {
        this.nr_firmy = nr_firmy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getKrs() {
        return krs;
    }

    public void setKrs(String krs) {
        this.krs = krs;
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

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public String getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(String nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public String getNr_zbioru_telefonow() {
        return nr_zbioru_telefonow;
    }

    public void setNr_zbioru_telefonow(String nr_zbioru_telefonow) {
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
    }

    @Override
    public String toString() {
        return "Firma{" +
                "nr_firmy=" + nr_firmy +
                ", nazwa='" + nazwa + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", krs='" + krs + '\'' +
                ", nr_konta='" + nr_konta + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", nr_klienta=" + nr_klienta +
                ", nr_adresu=" + nr_adresu +
                ", nr_zbioru_telefonow=" + nr_zbioru_telefonow +
                '}';
    }
}
