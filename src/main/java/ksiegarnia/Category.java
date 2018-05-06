package ksiegarnia;

public class Category {

    private int categoryId;
    private String name;
    private int priorityNumber;
    private static int id = 0;

    public Category(String name, int priorityNumber) {
        id++;
        this.categoryId = id;
        this.name = name;
        this.priorityNumber = priorityNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    @Override
    public String toString() {
        return categoryId + ". " + name + ", " + priorityNumber;
    }
}
