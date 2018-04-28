package ksiegarnia;

import java.util.ArrayList;
import java.util.List;

public class CategoriesData {

    List<Categories> categoriesList = new ArrayList<>();

    public void showCategories() {
        for (Categories category:categoriesList) {
            System.out.println(category);
        }
    }
}
