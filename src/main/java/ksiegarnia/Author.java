package ksiegarnia;

public class Author {

    private int authorId;
    private String name;
    private int age;
    private static int id = 0;

    public Author(String name, int age) {
        id++;
        this.authorId = id;
        this.name = name;
        this.age = age;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return authorId + ". " + name + " age:" + age;
    }
}
