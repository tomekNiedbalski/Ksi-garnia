package ksiegarnia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportFiles {

    public List<Book> importBooks() {

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
    public List<Categories> importCategories() {

        BufferedReader reader;
        List<Categories> categoriesList = new ArrayList<>();

        try {
            reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("categories.csv")));
            String line = reader.readLine();
            while (line != null) {
                Categories categories;
                String[] lineToken = line.split(";");
                int number = Integer.parseInt(lineToken[0]);
                String category = lineToken[1];
                int numberOfBooks = Integer.parseInt(lineToken[2]);
                categories = new Categories(number, category, numberOfBooks);
                categoriesList.add(categories);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd wczytywania danych");
        }
        return categoriesList;
    }
    public List<Author> importAuthors() {

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

}
