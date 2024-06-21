package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Kolonia {
    private int idKolonii;
    private int iloscMiejsc;
    private LocalDate dataRozpoczecia;
    private LocalDate dataZakonczenia;
    private BigDecimal cena;
    private int idMiejscowosci;
    private int idZakwaterowania;
    private int idAdres;

    // Getters and Setters
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

    public int getIdMiejscowosci() {
        return idMiejscowosci;
    }

    public void setIdMiejscowosci(int idMiejscowosci) {
        this.idMiejscowosci = idMiejscowosci;
    }

    public int getIdZakwaterowania() {
        return idZakwaterowania;
    }

    public void setIdZakwaterowania(int idZakwaterowania) {
        this.idZakwaterowania = idZakwaterowania;
    }

    public int getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(int idAdres) {
        this.idAdres = idAdres;
    }
}
