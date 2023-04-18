package zadatak4_napredna;

//Glavna klasa Main
public class Main {
	public static void main(String[] args) {
		Vozilo vozilo = new Vozilo("crvena", 50);
		vozilo.drive(); // Output: "Vozilo se kreæe brzinom od 50 km/h."
		vozilo.setColor("plava");
		System.out.println("Boja vozila je " + vozilo.getColor()); // Output: "Boja vozila je plava"

		Auto auto = new Auto("zelena", 70);
		auto.drive(); // Output: "Auto se kreæe brzinom od 70 km/h."
		auto.accelerate(); // Output: "Auto ubrzava. Nova brzina je 80 km/h."

		Kamion kamion = new Kamion("plava", 60);
		kamion.drive(); // Output: "Kamion se kreæe brzinom od 60 km/h."
		kamion.accelerate(); // Output: "Kamion ubrzava. Nova brzina je 65 km/h."
	}
}