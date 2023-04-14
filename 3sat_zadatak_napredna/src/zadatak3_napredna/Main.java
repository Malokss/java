package zadatak3_napredna;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Sale> sales = new ArrayList<>();
		sales.add(new Sale("Marko", "West", 500.0));
		sales.add(new Sale("Mirko", "East", 1000.0));
		sales.add(new Sale("Jasna", "North", 750.0));
		sales.add(new Sale("Lucija", "West", 1200.0));

		System.out.println("Total sales: " + StreamProcessor.getTotalSales(sales));
		System.out.println("Sales in West region: " + StreamProcessor.getSalesByRegion(sales, "West"));
		System.out.println("Top 2 sales people: " + StreamProcessor.getTopSalesPeople(sales, 2));
		System.out.println("Average sale: " + StreamProcessor.getAverageSale(sales));
	}
}
