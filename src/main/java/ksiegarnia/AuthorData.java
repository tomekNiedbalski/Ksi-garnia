package ksiegarnia;

import java.util.ArrayList;
import java.util.List;

public class AuthorData {

    private List<Author> authorList = new ArrayList<>();

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public void showAuthors() {
        for (Author author:authorList) {
            System.out.println(author);
        }
    }
}
