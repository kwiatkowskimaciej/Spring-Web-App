package com.example.servingwebcontent.database;

public class Pracownik {
    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private String data_urodzenia;
    private char plec;
    private String pesel;
    private String data_zatrudnienia;
    private String nr_konta;
    private String e_mail;
    private int nr_salonu;
    private int nr_serwisu;
    private int nr_adresu;
    private int nr_zbioru_telefonow;
    private int nr_stanowiska;

    public Pracownik(){
    }
    public Pracownik(int nr_pracownika, String imie, String nazwisko, String data_urodzenia, char plec, String pesel, String data_zatrudnienia, String nr_konta, String e_mail, int nr_salonu, int nr_serwisu, int nr_adresu, int nr_zbioru_telefonow, int nr_stanowiska) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.pesel = pesel;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_konta = nr_konta;
        this.e_mail = e_mail;
        this.nr_salonu = nr_salonu;
        this.nr_serwisu = nr_serwisu;
        this.nr_adresu = nr_adresu;
        this.nr_zbioru_telefonow = nr_zbioru_telefonow;
        this.nr_stanowiska = nr_stanowiska;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
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

    public int getNr_salonu() {
        return nr_salonu;
    }

    public void setNr_salonu(int nr_salonu) {
        this.nr_salonu = nr_salonu;
    }

    public int getNr_serwisu() {
        return nr_serwisu;
    }

    public void setNr_serwisu(int nr_serwisu) {
        this.nr_serwisu = nr_serwisu;
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

    public int getNr_stanowiska() {
        return nr_stanowiska;
    }

    public void setNr_stanowiska(int nr_stanowiska) {
        this.nr_stanowiska = nr_stanowiska;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", plec=" + plec +
                ", pesel='" + pesel + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", nr_konta='" + nr_konta + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", nr_salonu=" + nr_salonu +
                ", nr_serwisu=" + nr_serwisu +
                ", nr_adresu=" + nr_adresu +
                ", nr_zbioru_telefonow=" + nr_zbioru_telefonow +
                ", nr_stanowiska=" + nr_stanowiska +
                '}';
    }
}


