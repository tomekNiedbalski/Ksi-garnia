package ksiegarnia;

import java.util.List;

public class YearFirstBookPrintStrategy implements BookPrinterStrategy {
    @Override
    public void print(List<Book> books) {
        books.forEach(book -> System.out.println(book.getPublicationYear() + ", " + book.getTitle() + ", " + book.getIsbn()));
    }
}
