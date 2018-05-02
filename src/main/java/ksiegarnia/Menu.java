package ksiegarnia;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        BooksData booksData = BooksData.getInstance();
        AuthorData authorData = new AuthorData();
        CategoriesData categoriesData = CategoriesData.getInstance();

        menu.printMenu();
        menu.menuChoice(booksData, authorData, categoriesData);

    }

    private void printMenu() {
        System.out.println("---------Menu----------");
        System.out.println("1. EXIT");
        System.out.println("2. Kontakt");
        System.out.println("3. Wyświetl listę książek");
        System.out.println("4. Wyświetl ksiązki przed wybranym rokiem");
        System.out.println("5. Wyświetl autorów");
        System.out.println("6. Wyświetl książki wg kategorii");
    }

    private void menuChoice(BooksData booksData, AuthorData authorData, CategoriesData categoriesData) {
        Scanner scanner = new Scanner(System.in);
        ImportFiles importFiles = new ImportFiles();
        int choice = scanner.nextInt();
        authorData.setAuthorList(importFiles.importAuthors());
        booksData.setBooksList(importFiles.importBooks());
        categoriesData.setCategoriesList(importFiles.importCategories());
        while (choice != 1) {
            switch (choice) {
                case 2:
                    String emailKsiegarni = "ksiegarnia@o2.pl";
                    System.out.println("Kontakt:");
                    System.out.println(emailKsiegarni);
                    break;
                case 3:
                    booksData.setBooksList(importFiles.importBooks());
                    System.out.println("Ksiązki dostępne w księgarni:");
                    booksData.showBooks();
                    break;
                case 4:
                    booksData.setBooksList(importFiles.importBooks());
                    System.out.println("Podaj rok:");
                    int year = scanner.nextInt();
                    System.out.println("Książki dostępne w księgarni przed " + year + " rokiem:");
                    booksData.showBooksBeforeCertainYear(year);
                    break;
                case 5:
                    System.out.println("Ilość książek dostępnych od danego autora:");
                    authorData.showAuthors();
                    break;
                case 6:
                    System.out.println("Ksiązki wg kategorii:");
                    categoriesData.showCategories();
            }
            System.out.println();
            printMenu();
            choice = scanner.nextInt();
        }
    }
}
