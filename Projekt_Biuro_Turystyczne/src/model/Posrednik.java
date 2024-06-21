package model;

public class Posrednik {
    private int idPosrednika;
    private String nazwa;
    private String email;
    private String nrTelefonu;
    private int nip;
    private int idAdres;

    // Getters and Setters
    public int getIdPosrednika() {
        return idPosrednika;
    }

    public void setIdPosrednika(int idPosrednika) {
        this.idPosrednika = idPosrednika;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public int getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(int idAdres) {
        this.idAdres = idAdres;
    }
}
