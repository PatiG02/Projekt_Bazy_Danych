package model;

import javafx.beans.property.*;

public class Adres {
    private IntegerProperty idAdres;
    private StringProperty ulica;
    private StringProperty nrDomu;
    private IntegerProperty nrMieszkania;
    private StringProperty kodPocztowy;
    private IntegerProperty idMiejscowosci;
    
    public Adres() {
        this.idAdres = null;
        this.ulica = null;
        this.nrDomu = null;
        this.nrMieszkania = null;
        this.kodPocztowy = null;
        this.idMiejscowosci = null;
    }

    public Adres(int idAdres, String ulica, String nrDomu, int nrMieszkania, String kodPocztowy, int idMiejscowosci) {
        this.idAdres = new SimpleIntegerProperty(idAdres);
        this.ulica = new SimpleStringProperty(ulica);
        this.nrDomu = new SimpleStringProperty(nrDomu);
        this.nrMieszkania = new SimpleIntegerProperty(nrMieszkania);
        this.kodPocztowy = new SimpleStringProperty(kodPocztowy);
        this.idMiejscowosci = new SimpleIntegerProperty(idMiejscowosci);
    }

    public void setIdAdres(IntegerProperty idAdres) {
		this.idAdres = idAdres;
	}

	public void setUlica(StringProperty ulica) {
		this.ulica = ulica;
	}

	public void setNrDomu(StringProperty nrDomu) {
		this.nrDomu = nrDomu;
	}

	public void setNrMieszkania(IntegerProperty nrMieszkania) {
		this.nrMieszkania = nrMieszkania;
	}

	public void setKodPocztowy(StringProperty kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public void setIdMiejscowosci(IntegerProperty idMiejscowosci) {
		this.idMiejscowosci = idMiejscowosci;
	}

	// Getters
    public int getIdAdres() {
        return idAdres.get();
    }

    public String getUlica() {
        return ulica.get();
    }

    public String getNrDomu() {
        return nrDomu.get();
    }

    public int getNrMieszkania() {
        return nrMieszkania.get();
    }

    public String getKodPocztowy() {
        return kodPocztowy.get();
    }

    public int getIdMiejscowosci() {
        return idMiejscowosci.get();
    }

    // Property getters
    public IntegerProperty idAdresProperty() {
        return idAdres;
    }

    public StringProperty ulicaProperty() {
        return ulica;
    }

    public StringProperty nrDomuProperty() {
        return nrDomu;
    }

    public IntegerProperty nrMieszkaniaProperty() {
        return nrMieszkania;
    }

    public StringProperty kodPocztowyProperty() {
        return kodPocztowy;
    }

    public IntegerProperty idMiejscowosciProperty() {
        return idMiejscowosci;
    }
}
