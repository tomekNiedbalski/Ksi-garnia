package ksiegarnia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ExportFiles {

    private static final String EXPORT_FILE_ERROR_MESSAGE = "Błąd zapisywania danych";

    public void exportAuthorData(AuthorData authorData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("authors222.csv"))) {
            for (String element : getAuthorsDataAsStringToExport(authorData)) {
                writer.write(element);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(EXPORT_FILE_ERROR_MESSAGE);
        }
    }

    private List<String> getAuthorsDataAsStringToExport(AuthorData authorData) {
        List<String> listToExport = new ArrayList<>();
        for (Author author : authorData.getAuthorList()) {
            StringJoiner sj = new StringJoiner(";");
            sj.add(Integer.toString(author.getAuthorId()))
                    .add(author.getName())
                    .add(Integer.toString(author.getAge()));
            listToExport.add(sj.toString());
        }
        return listToExport;
    }

    public void exportCategoryData(CategoriesData categoriesData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("categories222.csv"))) {
            for (String element : getCategoryDataAsStringToExport(categoriesData)) {
                writer.write(element);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(EXPORT_FILE_ERROR_MESSAGE);
        }
    }

    private List<String> getCategoryDataAsStringToExport(CategoriesData categoriesData) {
        List<String> listToExport = new ArrayList<>();
        for (Category category : categoriesData.getCategoriesList()) {
            StringJoiner sj = new StringJoiner(";");
            sj.add(Integer.toString(category.getCategoryId()))
                    .add(category.getName())
                    .add(Integer.toString(category.getPriorityNumber()));
            listToExport.add(sj.toString());
        }
        return listToExport;
    }

    public void exportBookData(BooksData booksData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books222.csv"))) {
            for (String element : getBookDataAsStringToExport(booksData)) {
                writer.write(element);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(EXPORT_FILE_ERROR_MESSAGE);
        }
    }

    private List<String> getBookDataAsStringToExport(BooksData booksData) {
        List<String> listToExport = new ArrayList<>();
        for (Book book : booksData.getBooksList()) {
            StringJoiner sj = new StringJoiner(";");
            sj.add(book.getTitle())
                    .add(book.getIsbn())
                    .add(Integer.toString(book.getPublicationYear()))
                    .add(book.getBookBinding())
                    .add(getAuthorsDataAsInteger(book))
                    .add(Integer.toString(book.getCategory().getCategoryId()));
            listToExport.add(sj.toString());
        }
        return listToExport;
    }

    private String getAuthorsDataAsInteger(Book book) {
        StringJoiner sj = new StringJoiner(",");
        for (Author author : book.getAuthorList()) {
            sj.add(Integer.toString(author.getAuthorId()));
        }
        return sj.toString();
    }
}
