package ksiegarnia;

import java.util.List;

public class TitleFirstBookPrintStrategy implements BookPrinterStrategy {
    @Override
    public void print(List<Book> books) {
        books.forEach(book -> System.out.println(book.getTitle() + ", "
                + book.getPublicationYear() + ", "
                + book.getIsbn() + ", "
                + book.getBookBinding() + ", "
                + book.getAuthorList() + ", "
                + book.getCategory()));
    }
}
