package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class KoloniaUmowa {
    private int idUmowy;
    private String umowaNazwa;
    private int idKolonii;
    private int iloscMiejsc;
    private LocalDate dataRozpoczecia;
    private LocalDate dataZakonczenia;
    private BigDecimal cena;

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

    public int getIdKolonii() {
        return idKolonii;
    }

    public void setIdKolonii(int idKolonii) {
        this.idKolonii = idKolonii;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public LocalDate getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(LocalDate dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }
}
