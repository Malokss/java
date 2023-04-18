package zadatak4_napredna;

//Izvedena klasa Auto
class Auto extends Vozilo implements Accelerable {
	public Auto(String boja, int brzina) {
		super(boja, brzina);
	}

	@Override
	public void drive() {
		System.out.println("Auto se kreæe brzinom od " + brzina + " km/h.");
	}

	@Override
	public void accelerate() {
		brzina += 10;
		System.out.println("Auto ubrzava. Nova brzina je " + brzina + " km/h.");
	}
}
