package ksiegarnia;

import java.util.List;

public class BooksData {

    List<Book> booksList;

    public List<Book> getBooksList() {
        return booksList;
    }

    private static BooksData booksData = null;

    private BooksData(){

    }

    public static BooksData getInstance(){
        if(booksData == null){
            booksData = new BooksData();
        }
        return booksData;
    }

}
