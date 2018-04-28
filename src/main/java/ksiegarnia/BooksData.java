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

    private BooksData(){}

    public static BooksData getInstance(){
        if(booksData == null){
            booksData = new BooksData();
        }
        return booksData;
    }

    public void showBooks() {
        for (Book book : booksList) {
            System.out.println(book);
        }
    }

    public void showBooksBeforeCertainYear(int year){
        for (Book book:booksList) {
            if(book.getPublicationYear()<year){
                System.out.println(book);
            }
        }
//        booksList.stream().filter(x->x.getPublicationYear()<year).forEach(x-> System.out.println(x));
    }
}
