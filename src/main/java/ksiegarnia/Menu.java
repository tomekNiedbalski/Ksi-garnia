package ksiegarnia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        List<Book> bookList;

        menu.printMenu();
        menu.menuChoice();

        bookList = menu.booksReader();

        showBooks(bookList);
    }

    private static void showBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
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

    private void printMenu() {
        System.out.println("ksiegarnia.Menu:");
        System.out.println("1. EXIT");
        System.out.println("2. Kontakt");
    }

    private void menuChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice != 1) {
            switch (choice) {
                case 2:
                    String emailKsiegarni = "ksiegarnia@o2.pl";
                    System.out.println(emailKsiegarni);
                    break;
            }
            printMenu();
            choice = scanner.nextInt();
        }
    }
}
