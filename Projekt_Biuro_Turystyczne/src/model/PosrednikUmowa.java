package model;

public class PosrednikUmowa {
    private int idUmowy;
    private String umowaNazwa;
    private int idPosrednika;
    private String posrednikNazwa;
    private String email;
    private String nrTelefonu;
    private int nip;

    // Getters and Setters
    public int getIdUmowy() {
        return idUmowy;
    }

    public void setIdUmowy(int idUmowy) {
        this.idUmowy = idUmowy;
    }

    public String getUmowaNazwa() {
        return umowaNazwa;
    }

    public void setUmowaNazwa(String umowaNazwa) {
        this.umowaNazwa = umowaNazwa;
    }

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
}
