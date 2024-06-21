package model;

public class PosrednikUmowa {
    private int idPosrednika;
    private String posrednikNazwa;
    private String email;
    private String nrTelefonu;
    private int nip;
    private int umowaCount; // New field for the count of umowa

    // Getters and Setters
    public int getIdPosrednika() {
        return idPosrednika;
    }

    public void setIdPosrednika(int idPosrednika) {
        this.idPosrednika = idPosrednika;
    }

    public String getPosrednikNazwa() {
        return posrednikNazwa;
    }

    public void setPosrednikNazwa(String posrednikNazwa) {
        this.posrednikNazwa = posrednikNazwa;
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

    public int getUmowaCount() {
        return umowaCount;
    }

    public void setUmowaCount(int umowaCount) {
        this.umowaCount = umowaCount;
    }
}
