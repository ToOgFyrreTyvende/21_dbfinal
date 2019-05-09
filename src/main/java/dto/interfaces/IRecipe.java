package dto.interfaces;

import java.util.ArrayList;
import java.util.Collection;

public interface IRecipe {

    int getRecipeId();
    void setRecipeId(int recipeId);
    IProduct getRecipeProduct();
    void setRecipeProduct(IProduct recipeProduct);
    Collection getRecipeHistory();
    void setRecipeHistory(ArrayList recipeHistory);
    Collection getRecipeIngredients();
    void setRecipeIngredients(ArrayList recipeIngredients);
}
