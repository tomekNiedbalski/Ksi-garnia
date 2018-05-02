package ksiegarnia;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BooksFunctions {

    public Book findBookByISBN(List<Book> books, String ISBN) {
        Optional<Book> optional;
        optional = books.stream().filter(book -> book.getTitleNumber().equals(ISBN)).findFirst();
        if(optional.isPresent()){
            return optional.get();
        }
        throw new NullPointerException();
    }

    public Optional<Book> getBookByIsbn(List<Book> books, String ISBN) {
        return books.stream().filter(book -> book.getTitleNumber().equals(ISBN)).findFirst();
    }

    public List<Book> sortBooksByYearIncreasing(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(book -> book.getPublicationYear())).collect(Collectors.toList());
    }

    public List<Book> sortBooksByYearDecreasing(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear).reversed()).collect(Collectors.toList());
    }

    public List<Book> getTwoLastBooks(List<Book> books) {
        return books.stream().skip(books.size() - 2).collect(Collectors.toList());
    }

    public Book getTheNewestBook(List<Book> books) {
        Optional<Book> optional =books.stream().sorted(Comparator.comparing(Book::getPublicationYear).reversed()).findFirst();
        if(optional.isPresent()){
            return optional.get();
        }
        throw new NullPointerException();
    }

    public Book getTheOldestBook(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear)).findFirst().get();
    }

    public int getSumOfPublicationYear(List<Book> books) {
        return books.stream().mapToInt(Book::getPublicationYear).sum();
    }

    public List<Book> getBooksPublishedBeforeYear(List<Book> books, int year) {
        return books.stream().filter(book -> book.getPublicationYear() > year).collect(Collectors.toList());
    }

    public boolean checkIfAllBooksArePublishedBeforeYear(List<Book> books, int year) {
        return books.stream().allMatch(book -> book.getPublicationYear() < year);
//
//        List<Book> tempList = books.stream().filter(book -> book.getPublicationYear() < year).collect(Collectors.toList());
//        return tempList.isEmpty();
    }

    public double getAveragePublicationYear(List<Book> books) {
        return books.stream().mapToDouble(Book::getPublicationYear).average().getAsDouble();
    }

    public boolean checkIfAllBooksArePublishedAfterYear(List<Book> books, int year) {
        return books.stream().allMatch(book -> book.getPublicationYear()>year);
//        List<Book> tempList = books.stream().filter(book -> book.getPublicationYear() < year).collect(Collectors.toList());
//        return tempList.isEmpty();
    }

    public List<Book> getBooksStartedWithCertainLetterAndFilteredByYear(List<Book> books, String letter, int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() > year)
                .filter(book2 -> book2.getTitle().startsWith(letter))
                .collect(Collectors.toList());
    }

    public List<Book> addYearsToPublicationYear(List<Book> books){
        books.stream().forEach(book -> book.setPublicationYear(book.getPublicationYear()+100));
        return books;
//        return books.stream().map((Book book) -> {
//            book.setPublicationYear(book.getPublicationYear()+100);
//            return book;
//        }).collect(Collectors.toList());
    }

    public List<String> getTitlesWhereYearIsDividedBy2(List<Book> books){
        return books.stream().filter(book -> book.getPublicationYear()%2==0)
                .map(book2->book2.getTitle()).collect(Collectors.toList());
    }
}
