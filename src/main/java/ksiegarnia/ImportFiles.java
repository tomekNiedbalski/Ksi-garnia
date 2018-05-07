package ksiegarnia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportFiles {

    private static final String IMPORT_FILE_ERROR_MESSAGE = "Błąd wczytywania danych";

    public List<Book> importBooks() {

        BufferedReader reader;
        List<Book> bookList = new ArrayList<>();

        try {
            reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("books (2).csv")));
            String line = reader.readLine();

            while (line != null) {
                pharseLineToBookConstructor(bookList, line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(IMPORT_FILE_ERROR_MESSAGE);
        }
        return bookList;
    }

    private void pharseLineToBookConstructor(List<Book> bookList, String line) {

        CategoriesData categoriesData = CategoriesData.getInstance();
        AuthorData authorData = AuthorData.getInstance();
        Book book;
        String[] lineToken = line.split(";");
        String title = lineToken[0];
        String isbn = lineToken[1];
        int publicationYear = Integer.parseInt(lineToken[2]);
        String bookBinding = lineToken[3];
        String authorListNumbers = lineToken[4];
        String[] authorsId = authorListNumbers.split(",");
        String category = lineToken[5];

        List<Author> authorList = new ArrayList<>();
        for (int i = 0; i < authorsId.length; i++) {
            for (Author author1 : authorData.getAuthorList()) {
                if (authorsId[i].equals(Integer.toString(author1.getAuthorId()))) {
                    authorList.add(author1);
                }
            }
        }

        Category categories = new Category("", 1);
        for (Category categories1 : categoriesData.getCategoriesList()) {
            if (Integer.parseInt(category) == (categories1.getCategoryId())) {
                categories = categories1;
            }
        }

        book = new Book(title, isbn, publicationYear, bookBinding, authorList, categories);
        bookList.add(book);
    }

    public List<Category> importCategories() {

        BufferedReader reader;
        List<Category> categoriesList = new ArrayList<>();

        try {
            reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("categories.csv")));
            String line = reader.readLine();
            while (line != null) {
                Category categories;
                String[] lineToken = line.split(";");
                String category = lineToken[1];
                int numberOfBooks = Integer.parseInt(lineToken[2]);
                categories = new Category(category, numberOfBooks);
                categoriesList.add(categories);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(IMPORT_FILE_ERROR_MESSAGE);
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
                String authorName = lineToken[1];
                int numberOfBooks = Integer.parseInt(lineToken[2]);
                author = new Author(authorName, numberOfBooks);
                authorList.add(author);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(IMPORT_FILE_ERROR_MESSAGE);
        }
        return authorList;
    }
}
