package ksiegarnia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private String title;
    private long ISBN;
    private String titleNumber;
    private int publicationYear;

    public Book(String title, long ISBN, int publicationYear) {
        this.title = title;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public Book(String title, String titleNumber, int publicationYear) {
        this.title = title;
        this.titleNumber = titleNumber;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return title + ", "+ ISBN + ", "+publicationYear;
    }
}
