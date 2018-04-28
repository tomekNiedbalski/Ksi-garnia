package ksiegarnia;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        BooksData booksData = BooksData.getInstance();

        menu.printMenu();
        menu.menuChoice(booksData);

    }

    private void printMenu() {
        System.out.println("ksiegarnia.Menu:");
        System.out.println("1. EXIT");
        System.out.println("2. Kontakt");
        System.out.println("3. Wyświetl listę książek");
        System.out.println("4. Wyświetl ksiązki przed wybranym rokiem");
    }

    private void menuChoice(BooksData booksData) {
        Scanner scanner = new Scanner(System.in);
        ImportFiles importBooks = new ImportFiles();
        int choice = scanner.nextInt();
        while (choice != 1) {
            booksData.setBooksList(importBooks.importBooks());
            switch (choice) {
                case 2:
                    String emailKsiegarni = "ksiegarnia@o2.pl";
                    System.out.println(emailKsiegarni);
                    break;
                case 3:
                    System.out.println("Ksiązki dostępne w księgarni:");
                    booksData.showBooks();
                    break;
                case 4:
                    System.out.println("Podaj rok:");
                    int year = scanner.nextInt();
                    System.out.println("Książki dostępne w księgarni przed " + year + " rokiem:");
                    booksData.showBooksBeforeCertainYear(year);
                    break;
            }
            System.out.println();
            printMenu();
            choice = scanner.nextInt();
        }
    }
}
