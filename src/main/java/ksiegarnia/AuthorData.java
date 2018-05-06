package ksiegarnia;

import java.util.ArrayList;
import java.util.List;

public class AuthorData {

    private static AuthorData instance = new AuthorData();

    private AuthorData() {
    }

    public static AuthorData getInstance() {
        return instance;
    }

    private List<Author> authorList = new ArrayList<>();

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }
}
