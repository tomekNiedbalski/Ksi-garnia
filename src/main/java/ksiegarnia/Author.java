package ksiegarnia;

public class Author {

    private int number;
    private String name;
    private int numberOfBooks;

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
