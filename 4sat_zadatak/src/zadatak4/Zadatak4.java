package zadatak4;

import java.util.*;

public class Zadatak4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String> bookAuthors = new HashMap<>();
        List<String> sortedBooks = new ArrayList<>();

        while (true) {
            System.out.print("Unesite naslov knjige ili 'kraj' za završetak unosa: ");
            String bookTitle = input.nextLine();

            if (bookTitle.equalsIgnoreCase("kraj")) {
                break;
            }

            System.out.print("Unesite ime autora: ");
            String authorName = input.nextLine();

            bookAuthors.put(bookTitle, authorName);
            sortedBooks.add(bookTitle);
        }

        Set<String> uniqueBooks = new HashSet<>(sortedBooks);
        sortedBooks.clear();
        sortedBooks.addAll(uniqueBooks);
        sortedBooks.sort(Comparator.naturalOrder());

        System.out.println("Popis omiljenih knjiga:");

        sortedBooks.stream()
                   .map(bookTitle -> bookTitle + " od " + bookAuthors.get(bookTitle))
                   .forEach(System.out::println);
    }
}

