package dto.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IIngredient {
    int getIngredientId();
    void setIngredientId(int ingredientId);
    String getIngredientName();
    void setIngredientName(String ingredientName);
    boolean isActive();
    void setActive(boolean active);
    List getRecipeRawMatBatch();
    void setRecipeRawMatBatch(ArrayList recipeRawMatBatch);
    List getRecipes();
    void setRecipes(ArrayList recipes);
}
