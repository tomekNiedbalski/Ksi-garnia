package ksiegarnia;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BooksFunctionOnlyForTest {

    public Optional<Book> getBookByIsbn(List<Book> books, String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    public List<Book> getTwoLastBooks(List<Book> books) {
        return books.stream().skip(books.size() - 2).collect(Collectors.toList());
    }

    public Optional<Book> getTheNewestBook(List<Book> books) {
        return books.stream().max(Comparator.comparing(Book::getPublicationYear));
    }

    public Optional<Book> getTheOldestBook(List<Book> books) {
        return books.stream().min(Comparator.comparing(Book::getPublicationYear));
    }

    public int getSumOfPublicationYear(List<Book> books) {
        return books.stream().mapToInt(Book::getPublicationYear).sum();
    }

    public boolean checkIfAllBooksArePublishedBeforeYear(List<Book> books, int year) {
        return books.stream().allMatch(book -> book.getPublicationYear() < year);
    }

    public double getAveragePublicationYear(List<Book> books) {
        return books.stream().mapToDouble(Book::getPublicationYear).average().getAsDouble();
    }

    public boolean checkIfAllBooksArePublishedAfterYear(List<Book> books, int year) {
        return books.stream().allMatch(book -> book.getPublicationYear() > year);
    }

    public List<Book> getBooksStartedWithCertainLetterAndFilteredByYear(List<Book> books, String letter, int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() > year)
                .filter(book2 -> book2.getTitle().startsWith(letter))
                .collect(Collectors.toList());
    }

    public List<Book> addYearsToPublicationYear(List<Book> books) {
        books.forEach(book -> book.setPublicationYear(book.getPublicationYear() + 100));
        return books;
    }

    public List<String> getTitlesWhereYearIsDividedBy2(List<Book> books) {
        return books.stream().filter(book -> book.getPublicationYear() % 2 == 0)
                .map(Book::getTitle).collect(Collectors.toList());
    }


}
