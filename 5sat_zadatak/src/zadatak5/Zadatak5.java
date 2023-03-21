package zadatak5;

import java.util.Scanner;

public class Zadatak5 {
	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Evidencija evidencija = new Evidencija();

	        int odabranaOpcija = 0;
	        do {
	            System.out.println("Odaberite jednu od sljede�ih opcija:");
	            System.out.println("1. Dodaj studenta");
	            System.out.println("2. Pretraga po indeksu");
	            System.out.println("3. Ispi�i sve studente");
	            System.out.println("4. Izlaz");

	            odabranaOpcija = scanner.nextInt();
	            scanner.nextLine(); // Consuming newline character

	            switch (odabranaOpcija) {
	                case 1:
	                    // Dodavanje studenta
	                    System.out.print("Unesite ime studenta: ");
	                    String ime = scanner.nextLine();
	                    System.out.print("Unesite prezime studenta: ");
	                    String prezime = scanner.nextLine();
	                    System.out.print("Unesite broj indeksa studenta: ");
	                    String brojIndeksa = scanner.nextLine();
	                    System.out.print("Unesite godinu studija studenta: ");
	                    int godinaStudija = scanner.nextInt();
	                    scanner.nextLine(); // Consuming newline character
	                    Student noviStudent = new Student(ime, prezime, godinaStudija, brojIndeksa);
	                    evidencija.dodajStudenta(noviStudent);
	                    break;
	                case 2:
	                    // Pretraga po indeksu
	                    System.out.print("Unesite broj indeksa studenta kojeg tra�ite: ");
	                    brojIndeksa = scanner.nextLine();
	                    Student trazeniStudent = evidencija.pronadjiStudenta(brojIndeksa);
	                    if (trazeniStudent == null) {
	                        System.out.println("Student s tim brojem indeksa ne postoji u evidenciji.");
	                    } else {
	                        System.out.println("Prona�eni student: " + trazeniStudent.getIme() + " " + trazeniStudent.getPrezime());
	                    }
	                    break;
	                case 3:
	                    // Ispi�i sve studente
	                    evidencija.ispisiSveStudente();
	                    break;
	                case 4:
	                    // Izlaz
	                    System.out.println("Dovi�enja!");
	                    break;
	                default:
	                    System.out.println("Pogre�an unos, poku�ajte ponovno.");
	            }
	        } while (odabranaOpcija != 4);
	    }

	}	

