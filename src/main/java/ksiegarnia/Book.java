package ksiegarnia;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Book {

    private String title;
    private String Isbn;
    private int publicationYear;
    private String bookBinding;
    private List<Author> authorList;
    private Category category;

    public Book(String title, String Isbn, int publicationYear, String bookBinding, List<Author> authorList, Category category) {
        this.title = title;
        this.Isbn = Isbn;
        this.publicationYear = publicationYear;
        this.bookBinding = bookBinding;
        this.authorList = authorList;
        this.category = category;
    }

    public Book(String title, String Isbn, int publicationYear) {
        this.title = title;
        this.Isbn = Isbn;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return title + ", " + Isbn + ", " + publicationYear + ", " + authorList + ", " + category;
    }
}
