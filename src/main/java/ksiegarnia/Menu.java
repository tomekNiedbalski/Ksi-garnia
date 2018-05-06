package ksiegarnia;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.menuManager();

    }

    private Scanner scanner = new Scanner(System.in);
    private BooksData booksData = BooksData.getInstance();
    private AuthorData authorData = AuthorData.getInstance();
    private CategoriesData categoriesData = CategoriesData.getInstance();
    private ImportFiles importFiles = new ImportFiles();
    private ExportFiles exportFiles = new ExportFiles();
    private BooksFunctions booksFunctions = new BooksFunctions();
    private AuthorService authorService = new AuthorService();
    private CategoryService categoryService = new CategoryService();
    private BooksPrinter booksPrinter = new BooksPrinter(new TitleFirstBookPrintStrategy());

    private void menuManager() {

        authorData.setAuthorList(importFiles.importAuthors());
        categoriesData.setCategoriesList(importFiles.importCategories());
        booksData.setBooksList(importFiles.importBooks(authorData));

        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (Integer.parseInt(choice)) {
                case 1:
                    return;
                case 2:
                    System.out.println("księgarnia@o2.pl");
                    break;
                case 3:
                    bookShowingMenuManager();
                    break;
                case 4:
                    bookSortingMenuManager();
                    break;
                case 5:
                    authorService.showAuthors(authorData.getAuthorList());
                    break;
                case 6:
                    authorService.showAuthors(authorData.getAuthorList());
                    System.out.println("Wpisz ID autora:");
                    choice = scanner.nextLine();
                    booksPrinter.showAllBooks(booksFunctions.sortBookByAuthor(booksData.getBooksList(), Integer.parseInt(choice)));
                    break;
                case 7:
                    categoryService.showCategories(categoriesData.getCategoriesList());
                    break;
                case 8:
                    categoryService.showCategories(categoriesData.getCategoriesList());
                    System.out.println("Wpisz ID kategorii");
                    choice = scanner.nextLine();
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByCategory(booksData.getBooksList(), Integer.parseInt(choice)));
                    break;
                case 9:
                    editOptionManeger();
                    break;
                case 10:
                    exportFiles.exportAuthorData(authorData);
                    exportFiles.exportBookData(booksData);
                    exportFiles.exportCategoryData(categoriesData);
                    break;
                default:
                    System.out.println("Niewłaściwy wybór");
            }
        }

    }

    private void bookShowingMenuManager() {
        printBookShowingMenu();
        String choice = scanner.nextLine();
        switch (Integer.parseInt(choice)) {
            case 1:
                booksPrinter.setBookPrinterStrategy(new TitleFirstBookPrintStrategy());
                break;
            case 2:
                booksPrinter.setBookPrinterStrategy(new YearFirstBookPrintStrategy());
                break;
            case 3:
                booksPrinter.setBookPrinterStrategy(new IsbnFirstBookPrintStrategy());
                break;
            default:
                System.out.println("Błąd podczas zmiany spospobu wyświetlania");
        }
    }

    private void bookSortingMenuManager() {
        String choice;
        boolean exit = false;
        while (!exit) {
            printBookSortingMenu();
            choice = scanner.nextLine();
            switch (Integer.parseInt(choice)) {
                case 1:
                    System.out.println("Podaj rok:");
                    choice = scanner.nextLine();
                    booksPrinter.showAllBooks(booksFunctions.getBooksPublishedBeforeYear(booksData.getBooksList(), Integer.parseInt(choice)));
                    break;
                case 2:
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByYearIncreasing(booksData.getBooksList()));
                    break;
                case 3:
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByYearDecreasing(booksData.getBooksList()));
                    break;
                case 4:
                    booksPrinter.showAllBooks(booksFunctions.filterBooksByWzorceProjektowe(booksData.getBooksList()));
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Niewłaściwy wybór");
            }
        }
    }

    private void editOptionManeger() {
        boolean exit = false;
        while (!exit) {
            printEditMenu();
            String choice = scanner.nextLine();
            switch (Integer.parseInt(choice)) {
                case 1:
                    System.out.println("Podaj imię i nazwisko autora:");
                    String name = scanner.nextLine();
                    System.out.println("Podaj wiek:");
                    String age = scanner.nextLine();
                    authorService.addAuthor(authorData.getAuthorList(), name, Integer.parseInt(age));
                    break;
                case 2:
                    booksPrinter.showBooksForEditTitle(booksData.getBooksList());
                    System.out.println("Podaj ID książki:");
                    String bookId = scanner.nextLine();
                    System.out.println("Podaj nowy tytuł:");
                    String newTitle = scanner.nextLine();
                    booksFunctions.editBookTitle(booksData.getBooksList(), Integer.parseInt(bookId), newTitle);
                    break;
                case 3:
                    authorService.showAuthors(authorData.getAuthorList());
                    System.out.println("Podaj ID autora, którego wiek chcesz zmienić");
                    String authorID = scanner.nextLine();
                    System.out.println("Podaj nowy wiek:");
                    String newAge = scanner.nextLine();
                    authorService.editAuthorName(authorData.getAuthorList(), Integer.parseInt(authorID), Integer.parseInt(newAge));
                    break;
                case 4:
                    categoryService.showCategories(categoriesData.getCategoriesList());
                    System.out.println("Podaj nazwę nowej kategorii:");
                    String newCategory = scanner.nextLine();
                    System.out.println("Podaj priorytet nowej kategorii");
                    String priorityNumber = scanner.nextLine();
                    categoryService.addNewCategory(newCategory, Integer.parseInt(priorityNumber));
                    break;
                case 5:
                    System.out.println("Podaj ID kategorii");
                    String categoryId = scanner.nextLine();
                    System.out.println("Podaj nową nazwę:");
                    newCategory = scanner.nextLine();
                    categoryService.editCategoryName(newCategory, Integer.parseInt(categoryId));
                    break;
                case 6:
                    System.out.println("Opcja jeszcze nie zaimplementowana");
                    break;
                case 7:
                    exit = true;
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("----Księgarnia----");
        System.out.println("1. EXIT");
        System.out.println("2. Wyświetl kontakt");
        System.out.println("3. Wybierz sposób wyświetlania");
        System.out.println("4. Wyświetl książki wg:");
        System.out.println("5. Wyświetl autorów");
        System.out.println("6. Wyświetl książki danego autora");
        System.out.println("7. Wyświetl kategorie");
        System.out.println("8. Wyświetl ksiązki z danej kategorii");
        System.out.println("9. Opcje edycji");
        System.out.println("10. Exportuj dane");
        System.out.println();
    }

    private void printBookShowingMenu() {
        System.out.println("1. Tytuł pierwszy");
        System.out.println("2. Rok wydania pierwszy");
        System.out.println("3. Isbn pierwszy");
    }

    private void printBookSortingMenu() {
        System.out.println("1. Wyświetl ksiązki wydane przed wybranym rokiem");
        System.out.println("2. Wyświetl ksiązki posortowane wg roku rosnąco");
        System.out.println("3. Wyświetl ksiązki posortowane wg roku malejąco");
        System.out.println("4. Wyświetl ksiązki z kategorii wzorce projektowe");
        System.out.println("5. Powrót do głównego menu");
    }

    private void printEditMenu() {
        System.out.println("1. Dodaj autora");
        System.out.println("2. Edytuj nazwę ksiązki");
        System.out.println("3. Edytuj wiek autora");
        System.out.println("4. Dodaj nową kategorię");
        System.out.println("5. Edytuj nazwę kategorii");
        System.out.println("6. Dodanie nowej ksiązki");
        System.out.println("7. Powrót do głównego menu");
    }
}
