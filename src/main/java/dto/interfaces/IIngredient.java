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
    List<IRawMatBatch> getRecipeRawMatBatch();
    void setRecipeRawMatBatch(List<IRawMatBatch> recipeRawMatBatch);
    List<IRecipe> getRecipes();
    void setRecipes(List<IRecipe> recipes);
}
