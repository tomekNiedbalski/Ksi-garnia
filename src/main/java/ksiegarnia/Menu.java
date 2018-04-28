package ksiegarnia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        BooksData booksData = BooksData.getInstance();
        booksData.booksList = menu.booksReader();

        menu.printMenu();
        menu.menuChoice(booksData.booksList);

    }

    private static void showAuthors(List<Author> authorList) {
        for (Author author:authorList) {
            System.out.println(author);
        }
    }

    private List<Book> booksReader() {

        BufferedReader reader;
        List<Book> bookList = new ArrayList<>();

        try {
            reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("books.csv")));
            String line = reader.readLine();

            while (line != null) {
                Book book;
                String[] lineToken = line.split(";");
                String title = lineToken[0];
                int titleNumber = Integer.parseInt(lineToken[1]);
                int publicationYear = Integer.parseInt(lineToken[2]);
                book = new Book(title, titleNumber, publicationYear);
                bookList.add(book);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd wczytywania danych");
        }
        return bookList;
    }

    private List<Author> authorReader() {

        BufferedReader reader;
        List<Author> authorList = new ArrayList<>();

        try {
            reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("authors.csv")));
            String line = reader.readLine();

            while (line != null) {
                Author author;
                String[] lineToken = line.split(";");
                int number = Integer.parseInt(lineToken[0]);
                String authorName = lineToken[1];
                int numberOfBooks = Integer.parseInt(lineToken[2]);
                author = new Author(number, authorName, numberOfBooks);
                authorList.add(author);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd wczytywania danych");
        }
        return authorList;
    }

    private void printMenu() {
        System.out.println("ksiegarnia.Menu:");
        System.out.println("1. EXIT");
        System.out.println("2. Kontakt");
        System.out.println("3. Wyświetl listę książek:");
    }

    private void menuChoice(List<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice != 1) {
            switch (choice) {
                case 2:
                    String emailKsiegarni = "ksiegarnia@o2.pl";
                    System.out.println(emailKsiegarni);
                    break;
                case 3:
                    showBooks(bookList);
            }
            printMenu();
            choice = scanner.nextInt();
        }
    }

    private static void showBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
