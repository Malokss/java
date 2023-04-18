package zadatak4_napredna;

//Izvedena klasa Kamion
class Kamion extends Vozilo implements Accelerable {
	public Kamion(String boja, int brzina) {
		super(boja, brzina);
	}

	@Override
	public void drive() {
		System.out.println("Kamion se kreæe brzinom od " + brzina + " km/h.");
	}

	@Override
	public void accelerate() {
		brzina += 5;
		System.out.println("Kamion ubrzava. Nova brzina je " + brzina + " km/h.");
	}
}