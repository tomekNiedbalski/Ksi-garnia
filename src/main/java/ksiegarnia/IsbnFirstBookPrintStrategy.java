package ksiegarnia;

import java.util.List;

public class IsbnFirstBookPrintStrategy implements BookPrinterStrategy {
    @Override
    public void print(List<Book> books) {
        books.forEach(book -> System.out.println(book.getIsbn() + ", " + book.getTitle() + ", " + book.getPublicationYear()));
    }
}
