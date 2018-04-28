package ksiegarnia;

import lombok.Getter;

@Getter
public class Book {

    private String title;
    private int ISBN;
    private int publicationYear;

    public Book(String title, int titleNumber, int publicationYear) {
        this.title = title;
        this.ISBN = titleNumber;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return title + ", "+ ISBN + ", "+publicationYear;
    }
}
