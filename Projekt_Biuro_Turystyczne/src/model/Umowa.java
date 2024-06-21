package model;

public class Umowa {
    private int idUmowy;
    private String nazwa;
    private int idPosrednika;
    private int idKolonii;
    private int idOsoba;
    private int idTransportu;
    private int idWyzywienia;

    // Getters and Setters
    public int getIdUmowy() {
        return idUmowy;
    }

    public void setIdUmowy(int idUmowy) {
        this.idUmowy = idUmowy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIdPosrednika() {
        return idPosrednika;
    }

    public void setIdPosrednika(int idPosrednika) {
        this.idPosrednika = idPosrednika;
    }

    public int getIdKolonii() {
        return idKolonii;
    }

    public void setIdKolonii(int idKolonii) {
        this.idKolonii = idKolonii;
    }

    public int getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(int idOsoba) {
        this.idOsoba = idOsoba;
    }

    public int getIdTransportu() {
        return idTransportu;
    }

    public void setIdTransportu(int idTransportu) {
        this.idTransportu = idTransportu;
    }

    public int getIdWyzywienia() {
        return idWyzywienia;
    }

    public void setIdWyzywienia(int idWyzywienia) {
        this.idWyzywienia = idWyzywienia;
    }
}
