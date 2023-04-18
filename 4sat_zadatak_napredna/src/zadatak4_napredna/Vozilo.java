package zadatak4_napredna;

//Osnovna klasa Vozilo
class Vozilo {
	protected String boja;
	protected int brzina;

	public Vozilo(String boja, int brzina) {
		this.boja = boja;
		this.brzina = brzina;
	}

	public void drive() {
		System.out.println("Vozilo se kreæe brzinom od " + brzina + " km/h.");
	}

	public void setColor(String boja) {
		this.boja = boja;
	}

	public String getColor() {
		return boja;
	}
}