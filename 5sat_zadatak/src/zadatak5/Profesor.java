package zadatak5;

public class Profesor extends Osoba {
    private String predmet;

    public Profesor(String ime, String prezime, String predmet) {
        super(ime, prezime);
        this.predmet = predmet;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }
}