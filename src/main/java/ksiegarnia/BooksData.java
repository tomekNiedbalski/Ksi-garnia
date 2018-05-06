package ksiegarnia;

import java.util.List;

public class BooksData {

    private List<Book> booksList;

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    private static BooksData booksData = null;

    private BooksData() {
    }

    public static BooksData getInstance() {
        if (booksData == null) {
            booksData = new BooksData();
        }
        return booksData;
    }

    public void showBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
