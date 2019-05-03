package dto.interfaces;

public interface IRecipeHistory {
    int getRecipeHistId();
    void setRecipeHistId(int recipeHistId);
    IRecipe getRecipeHistoryRecipe();
    void setRecipeHistoryRecipe(IRecipe recipeHistoryRecipe);
}
