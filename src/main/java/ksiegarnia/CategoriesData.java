package ksiegarnia;

import java.util.ArrayList;
import java.util.List;

public class CategoriesData {

    private List<Categories> categoriesList = new ArrayList<>();
    private static CategoriesData categoriesData = null;

    private CategoriesData(){}

    public static CategoriesData getInstance(){
        if(categoriesData == null){
            categoriesData = new CategoriesData();
        }
        return categoriesData;
    }

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public void showCategories() {
        for (Categories category:categoriesList) {
            System.out.println(category);
        }
    }
}
