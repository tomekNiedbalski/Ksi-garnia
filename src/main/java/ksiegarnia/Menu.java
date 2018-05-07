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
    private final String WRONGCHOICE = "Niewłaściwy wybór";


    private void menuManager() {

        authorData.setAuthorList(importFiles.importAuthors());
        categoriesData.setCategoriesList(importFiles.importCategories());
        booksData.setBooksList(importFiles.importBooks());

        while (true) {
            printMenu();
            int choiceNumber = 1000;
            String choice = scanner.nextLine();
            try {
                choiceNumber = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choiceNumber) {
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
                    editingOptionManager();
                    break;
                case 10:
                    exportFiles.exportAuthorData(authorData);
                    exportFiles.exportBookData(booksData);
                    exportFiles.exportCategoryData(categoriesData);
                    break;
                default:
                    System.out.println(WRONGCHOICE);
            }
        }

    }

    private void bookShowingMenuManager() {
        printBookShowingMenu();
        int choiceNumber = 1000;
        String choice = scanner.nextLine();
        try {
            choiceNumber = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        switch (choiceNumber) {
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
        boolean exit = false;
        while (!exit) {
            printBookSortingMenu();
            String choice = scanner.nextLine();
            int choiceNumber = 1000;
            try {
                choiceNumber = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choiceNumber) {
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
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByWzorceProjektowe(booksData.getBooksList()));
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println(WRONGCHOICE);
            }
        }
    }

    private void editingOptionManager() {
        int choiceNumber = 1000;
        boolean exit = false;
        while (!exit) {
            printEditMenu();
            String choice = scanner.nextLine();
            try {
                choiceNumber = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choiceNumber) {
                case 1:
                    addingAuthorManager();
                    break;
                case 2:
                    editingBookTitleManager();
                    break;
                case 3:
                    editingAuthorAgeManager();
                    break;
                case 4:
                    addingNewCategoryManager();
                    break;
                case 5:
                    editingCategoryManager();
                    break;
                case 6:
                    System.out.println("Opcja jeszcze niezaimplementowana");
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println(WRONGCHOICE);
            }
        }
    }

    private void editingCategoryManager() {
        boolean keepEditingCategory = true;
        int parsedCategoryId = 0;
        while (keepEditingCategory) {
            categoryService.showCategories(categoriesData.getCategoriesList());
            System.out.println("Podaj ID kategorii");
            String categoryId = scanner.nextLine();
            try {
                categoryService.checkForCorrectId(categoriesData.getCategoriesList(), Integer.parseInt(categoryId));
                keepEditingCategory = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj Id jako liczbę");
            } catch (NoSuchIdException e) {
                System.out.println("Nie posiadamy kategorii o podanym ID");
            }
        }
        System.out.println("Podaj nową nazwę lub naciśnij A aby anulować");
        String newCategory = scanner.nextLine();
        if (newCategory.equalsIgnoreCase("a"))
            return;
        categoryService.editCategoryName(newCategory, parsedCategoryId);
    }

    private void addingNewCategoryManager() {
        boolean keepAddingNewCategory = true;
        String newCategory = "";
        int parsedPriorityNumber = 0;
        while (keepAddingNewCategory) {
            categoryService.showCategories(categoriesData.getCategoriesList());
            System.out.println("Podaj nazwę nowej kategorii:");
            newCategory = scanner.nextLine();
            System.out.println("Podaj priorytet nowej kategorii");
            String priorityNumber = scanner.nextLine();
            try {
                parsedPriorityNumber = Integer.parseInt(priorityNumber);
                keepAddingNewCategory = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj priorytet jako liczbę");
            }
        }
        categoryService.addNewCategory(newCategory, parsedPriorityNumber);
    }

    private void editingAuthorAgeManager() {
        boolean keepEditing = true;
        String authorID = "";
        int parsedNewAge = 0;
        while (keepEditing) {
            authorService.showAuthors(authorData.getAuthorList());
            System.out.println("Podaj ID autora, którego wiek chcesz zmienić");
            authorID = scanner.nextLine();
            try {
                authorService.checkForCorrectId(authorData.getAuthorList(), Integer.parseInt(authorID));
                System.out.println("Podaj nowy wiek:");
                String newAge = scanner.nextLine();
                parsedNewAge = Integer.parseInt(newAge);
                keepEditing = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj ID/wiek jako liczbę");
            } catch (NoSuchIdException e) {
                System.out.println("Nie posiadamy autora o takim ID");
            }
        }
        authorService.editAuthorName(authorData.getAuthorList(), Integer.parseInt(authorID), parsedNewAge);
    }

    private void editingBookTitleManager() {
        boolean incorrectId = true;
        String bookId = "";
        while (incorrectId) {
            booksPrinter.showBooksForEditTitle(booksData.getBooksList());
            System.out.println("Podaj ID książki:");
            bookId = scanner.nextLine();
            try {
                booksFunctions.checkForCorrectId(booksData.getBooksList(), Integer.parseInt(bookId));
                incorrectId = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj ID jako liczbę");
            } catch (NoSuchIdException e) {
                System.out.println("Nie posiadamy ksiązki o takim ID");
            }
        }
        System.out.println("Podaj nowy tytuł albo naciśnij A aby anulować");
        String newTitle = scanner.nextLine();
        if (newTitle.equalsIgnoreCase("a"))
            return;
        booksFunctions.editBookTitle(booksData.getBooksList(), Integer.parseInt(bookId), newTitle);
    }

    private void addingAuthorManager() {
        int ageParsed = 0;
        boolean keppAddingAuthor = true;
        System.out.println("Podaj imię i nazwisko autora:");
        String name = scanner.nextLine();
        while (keppAddingAuthor) {
            System.out.println("Podaj wiek autora albo naciśnij A, aby anulować dodawanie");
            String age = scanner.nextLine();
            if (age.equalsIgnoreCase("a")) {
                break;
            }
            try {
                ageParsed = Integer.parseInt(age);
                keppAddingAuthor = false;
            } catch (NumberFormatException e) {
                System.out.println("Zły format!");
            }
        }
        authorService.addAuthor(authorData.getAuthorList(), name, ageParsed);
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