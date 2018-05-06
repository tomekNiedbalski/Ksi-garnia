package ksiegarnia;

import java.util.List;

public interface BookPrinterStrategy {

    void print(List<Book> books);
}