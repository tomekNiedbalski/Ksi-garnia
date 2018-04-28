package ksiegarnia;

public class Categories {

    private int number;
    private String name;
    private int numberOfBooks;

    public Categories(int number, String name, int numberOfBooks) {
        this.number = number;
        this.name = name;
        this.numberOfBooks = numberOfBooks;
    }

    @Override
    public String toString() {
        return number + ". " + name +", " + numberOfBooks;
    }
}
