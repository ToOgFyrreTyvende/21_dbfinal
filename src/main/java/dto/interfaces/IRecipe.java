package dto.interfaces;

import java.util.List;

public interface IRecipe {

    int getRecipeId();
    void setRecipeId(int recipeId);
    IProduct getRecipeProduct();
    void setRecipeProduct(IProduct recipeProduct);
    List<IRecipeHistory> getRecipeHistory();
    void setRecipeHistory(List<IRecipeHistory> recipeHistory);
    List<IIngredient> getRecipeIngredients();
    void setRecipeIngredients(List<IIngredient> recipeIngredients);
}
