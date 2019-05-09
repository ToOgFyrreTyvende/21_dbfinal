package dto.interfaces;

import java.util.ArrayList;
import java.util.Collection;

public interface IIngredient {
    int getIngredientId();
    void setIngredientId(int ingredientId);
    String getIngredientName();
    void setIngredientName(String ingredientName);
    boolean isActive();
    void setActive(boolean active);
    Collection getRecipeRawMatBatch();
    void setRecipeRawMatBatch(ArrayList recipeRawMatBatch);
    Collection getRecipes();
    void setRecipes(ArrayList recipes);
}
