package ksiegarnia;

import java.util.List;

public class CategoryService {

    public void addNewCategory(String name, int priorityNumber) {
        CategoriesData categoriesData = CategoriesData.getInstance();
        categoriesData.getCategoriesList().add(new Category(name, priorityNumber));

    }

    public void editCategoryName(String name, int index) {
        CategoriesData categoriesData = CategoriesData.getInstance();
        categoriesData.getCategoriesList().get(index-1).setName(name);

    }

    public void showCategories(List<Category> categories) {
        for (Category category : categories) {
            System.out.println(category);
        }
    }
}
