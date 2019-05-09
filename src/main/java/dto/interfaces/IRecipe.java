package dto.interfaces;

import java.util.Set;

public interface IRecipe {

    int getRecipeId();
    void setRecipeId(int recipeId);
    IProduct getRecipeProduct();
    void setRecipeProduct(IProduct recipeProduct);
    Set<IRecipeHistory> getRecipeHistory();
    void setRecipeHistory(Set<IRecipeHistory> recipeHistory);
    Set<IIngredient> getRecipeIngredients();
    void setRecipeIngredients(Set<IIngredient> recipeIngredients);
}
