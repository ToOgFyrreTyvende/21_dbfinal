package dto.interfaces;

import java.util.Set;

public interface IIngredient {
    int getIngredientId();
    void setIngredientId(int ingredientId);
    boolean isActive();
    void setActive(boolean active);
    Set<IRawMatBatch> getRecipeRawMatBatch();
    void setRecipeRawMatBatch(Set<IRawMatBatch> recipeRawMatBatch);
    Set<IRecipe> getRecipes();
    void setRecipes(Set<IRecipe> recipes);
}
