package zadatak3_napredna;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamProcessor {
	public static double getTotalSales(List<Sale> sales) {
		return sales.stream().mapToDouble(Sale::getAmount).sum();
	}

	public static List<Sale> getSalesByRegion(List<Sale> sales, String region) {
		return sales.stream().filter(sale -> sale.getRegion().equals(region)).collect(Collectors.toList());
	}

	public static List<String> getTopSalesPeople(List<Sale> sales, int n) {
		return sales.stream()
				.collect(Collectors.groupingBy(Sale::getSalesPerson, Collectors.summingDouble(Sale::getAmount)))
				.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(n)
				.map(Map.Entry::getKey).collect(Collectors.toList());
	}

	public static double getAverageSale(List<Sale> sales) {
		return sales.stream().mapToDouble(Sale::getAmount).average().orElse(0);
	}
}