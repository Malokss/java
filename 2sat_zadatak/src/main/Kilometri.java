package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kilometri {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Unos broja kilometara
        System.out.print("Unesite broj kilometara: ");
        double kilometri = scanner.nextDouble();

        // Provjera jesu li kilometri pozitivan broj
        if (kilometri < 0) {
            System.out.println("Upozorenje: Unijeli ste negativan broj kilometara!");
            return;
        }

        // Unos konverzijskog faktora
        System.out.print("Unesite konverzijski faktor za kilometre u milje: ");
        double konverzijskiFaktor = scanner.nextDouble();

        // Provjera je li konverzijski faktor pozitivan broj
        if (konverzijskiFaktor < 0) {
            System.out.println("Upozorenje: Unijeli ste negativan konverzijski faktor!");
            return;
        }

//        // Spremanje konverzijskog faktora u datoteku
//        try (PrintWriter writer = new PrintWriter(new FileWriter("konverzijski_faktor.txt"))) {
//            writer.print(konverzijskiFaktor);
//        } catch (IOException e) {
//            System.out.println("Upozorenje: Neuspjelo spremanje konverzijskog faktora u datoteku!");
//        }

        // Èitanje konverzijskog faktora iz datoteke
        double ucitaniKonverzijskiFaktor = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("konverzijski_faktor.txt"))) {
            ucitaniKonverzijskiFaktor = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            System.out.println("Upozorenje: Neuspjelo èitanje konverzijskog faktora iz datoteke!");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Upozorenje: Neispravan format konverzijskog faktora u datoteci!");
            return;
        }
        System.out.println(konverzijskiFaktor);
        System.out.println(ucitaniKonverzijskiFaktor);

        // Provjera jednakosti unesenog i uèitanog konverzijskog faktora
        if (konverzijskiFaktor != ucitaniKonverzijskiFaktor) {
            System.out.println("Upozorenje: Uneseni konverzijski faktor se ne podudara s uèitanim iz datoteke!");
            return;
        }

        // Izraèunavanje milja i ispis rezultata
        int milje = (int) Math.round(kilometri / konverzijskiFaktor);
        System.out.println("Uneseno je " + kilometri + " kilometara, što je " + milje + " milja.");
    }
}
