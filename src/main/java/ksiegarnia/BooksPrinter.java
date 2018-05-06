package ksiegarnia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BooksPrinter {

    private BookPrinterStrategy bookPrinterStrategy;

    public BooksPrinter(BookPrinterStrategy bookPrinterStrategy) {
        this.bookPrinterStrategy = bookPrinterStrategy;
    }

    public void setBookPrinterStrategy(BookPrinterStrategy bookPrinterStrategy) {
        this.bookPrinterStrategy = bookPrinterStrategy;
    }

    public void showAllBooks(List<Book> books) {
        bookPrinterStrategy.print(books);
    }

    public void showBooksForEditTitle(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". "
                    + books.get(i).getTitle() + " "
                    + books.get(i).getAuthorList() + " "
                    + books.get(i).getCategory().getName());
        }
    }

    public void  printAllBooksForCertainAuthor(List<Author> authors, List<Book> books, int choice) {
        List<Book> tempList = new ArrayList<>();
        Optional optional = authors.stream()
                .filter(author -> author.getAuthorId() == choice)
                .map(Author::getName)
                .findFirst();
        if (optional.isPresent()) {
            String name = (String) optional.get();
            for (Book book : books) {
                for (Author author : book.getAuthorList()) {
                    if (author.getName().contains(name)) {
                        tempList.add(book);
                    }
                }
            }
            if (!tempList.isEmpty())
                System.out.println(tempList);
            else
                System.out.println("Nie posiadamy ksiązek podanego autora");
        } else System.out.println("Podano złe ID");
    }

    public void printAllBooksForCertainCategory(List<Book> books, int choice) {
        books.stream().filter(book -> book.getCategory().getCategoryId() == choice).forEach(System.out::println);

    }
}
