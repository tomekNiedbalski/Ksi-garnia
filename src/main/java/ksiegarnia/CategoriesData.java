package ksiegarnia;

import java.util.ArrayList;
import java.util.List;

public class CategoriesData {

    private List<Category> categoriesList = new ArrayList<>();
    private static CategoriesData categoriesData = null;

    private CategoriesData() {
    }

    public static CategoriesData getInstance() {
        if (categoriesData == null) {
            categoriesData = new CategoriesData();
        }
        return categoriesData;
    }

    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

}
