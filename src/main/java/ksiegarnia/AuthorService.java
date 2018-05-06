package ksiegarnia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorService {

    public void addAuthor(List<Author> authors, String name, int age) {
        authors.add(new Author(name, age));
    }

    public void editAuthorName(List<Author> authors, int choice, int age) {
        authors.get(choice - 1).setAge(age);
    }

    public void showAuthors(List<Author> authors) {
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    public void printAuthorsWithNumberOfBooks(List<Author> authorList) {
        Integer number;
        Map<Author, Integer> tempList = new HashMap<>();
        BooksData booksData = BooksData.getInstance();
        for (Author author : authorList) {
            number = 0;
            for (Book book : booksData.getBooksList()) {
                if (book.getAuthorList().contains(author)) {
                    number++;
                }
            }
            tempList.put(author, number);
        }
        System.out.println(tempList);
    }

    public void próba() {
        int number = 0;
        Map<Author, Integer> tempMap = new HashMap<>();
        AuthorData authorData = AuthorData.getInstance();
        BooksData booksData = BooksData.getInstance();

        for (Author authorAuthor : authorData.getAuthorList()) {
            for (Book book : booksData.getBooksList()) {
                for (Author authorBook : book.getAuthorList()) {
                    if (authorAuthor.getAuthorId() == authorBook.getAuthorId()) {
                        number++;
                    }
                }
            }
            tempMap.put(authorAuthor, number);
            number = 0;
        }
        System.out.println(tempMap);
    }
}
