package zadatak5;

import java.util.ArrayList;

public class Evidencija {
    private ArrayList<Student> listaStudenata;

    public Evidencija() {
        listaStudenata = new ArrayList<Student>();
    }

    public void dodajStudenta(Student student) {
        listaStudenata.add(student);
    }

    public Student pronadjiStudenta(String brojIndeksa) {
        for (Student student : listaStudenata) {
            if (student.getBrojIndeksa().equals(brojIndeksa)) {
                return student;
            }
        }
        return null;
    }

    public void ispisiSveStudente() {
        for (Student student : listaStudenata) {
            System.out.println("Ime: " + student.getIme() +
                    " Prezime: " + student.getPrezime() +
                    " Godina studija: " + student.getGodinaStudija() +
                    " Broj indeksa: " + student.getBrojIndeksa());
        }
    }
}
