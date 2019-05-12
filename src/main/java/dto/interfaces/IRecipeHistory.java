package dto.interfaces;

import java.util.Date;

public interface IRecipeHistory {
    int getRecipeHistId();
    void setRecipeHistId(int recipeHistId);
    int getIngredientId();
    void setIngredientId(int ingredientId);
    int getProductId();
    void setProductId(int productId);
    // IRecipe getRecipeHistoryRecipe();
    // void setRecipeHistoryRecipe(IRecipe recipeHistoryRecipe);
    String getAction();
    void setAction(String action);
    double getAmount();
    void setAmount(double amount);
    Date getTimeStamp();
    void setTimeStamp(Date timeStamp);
}
