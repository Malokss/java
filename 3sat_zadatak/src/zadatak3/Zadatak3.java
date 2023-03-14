package zadatak3;

import java.util.Scanner;

public class Zadatak3 {
	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int number = 0;
	        int sum = 0;

	        while (true) {
	            System.out.print("Unesite cijeli broj: ");
	            String input = scanner.nextLine();

	            try {
	                number = Integer.parseInt(input);
	            } catch (NumberFormatException e) {
	                System.out.println("Pogrešan unos. Molimo unesite cijeli broj.");
	                continue;
	            }

	            if (number < 0) {
	                break;
	            }

	            switch (number % 7) {
	                case 0:
	                    System.out.println("Nedjelja");
	                    break;
	                case 1:
	                    System.out.println("Ponedjeljak");
	                    break;
	                case 2:
	                    System.out.println("Utorak");
	                    break;
	                case 3:
	                    System.out.println("Srijeda");
	                    break;
	                case 4:
	                    System.out.println("Èetvrtak");
	                    break;
	                case 5:
	                    System.out.println("Petak");
	                    break;
	                case 6:
	                    System.out.println("Subota");
	                    break;
	            }

	            if (number == 0) {
	                continue;
	            } else if (number % 2 == 0) {
	                sum += number;
	            } else {
	                break;
	            }
	        }

	        System.out.println("Zbroj svih parnih brojeva je: " + sum);
	}
}
