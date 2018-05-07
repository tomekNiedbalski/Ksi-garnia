package ksiegarnia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BooksFunctions {

    public List<Book> sortBooksByYearIncreasing(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getPublicationYear))
                .collect(Collectors.toList());
    }

    public List<Book> sortBooksByYearDecreasing(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getPublicationYear).reversed())
                .collect(Collectors.toList());
    }

    public List<Book> getBooksPublishedBeforeYear(List<Book> books, int year) {
        return books.stream().filter(book -> book.getPublicationYear() < year).collect(Collectors.toList());
    }

    public List<Book> sortBooksByWzorceProjektowe(List<Book> books) {
        return books.stream()
                .filter(book -> book.getCategory().getName().equalsIgnoreCase("Wzorce projektowe"))
                .collect(Collectors.toList());
    }

    public void editBookTitle(List<Book> books, int bookId, String title) {
        books.get(bookId - 1).setTitle(title);
    }

    public List<Book> sortBookByAuthor(List<Book> booksList, int authorId) {
        List<Book> tempList = new ArrayList<>();
        for (Book book : booksList) {
            for (Author author : book.getAuthorList()) {
                if (author.getAuthorId() == authorId) {
                    tempList.add(book);
                }
            }
        }
        return tempList;
    }

    public List<Book> sortBooksByCategory(List<Book> booksList, int choice) {
        return booksList.stream()
                .filter(book -> book.getCategory().getCategoryId() == choice)
                .collect(Collectors.toList());

    }

    public boolean checkForCorrectId(List<Book> books, int choice){
        if(choice<1||(choice-1)>=books.size())
            throw new NoSuchIdException();
        return true;
    }
}
