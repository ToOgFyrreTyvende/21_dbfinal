package dto.interfaces;

import java.util.Date;

public interface IRecipeHistory {
    int getRecipeHistId();
    void setRecipeHistId(int recipeHistId);
    IRecipe getRecipeHistoryRecipe();
    void setRecipeHistoryRecipe(IRecipe recipeHistoryRecipe);
    String getAction();
    void setAction(String action);
    Date getTimeStamp();
    void setTimeStamp(Date timeStamp);
}
