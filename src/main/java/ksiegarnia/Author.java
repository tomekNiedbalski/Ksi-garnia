package ksiegarnia;

public class Author {

    int number;
    String name;
    int numberOfBooks;

    public Author(int number, String name, int age) {
        this.number = number;
        this.name = name;
        this.numberOfBooks = age;
    }

    @Override
    public String toString() {
        return number +". " + name + ", " + numberOfBooks;
    }
}
