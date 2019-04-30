package dto;

import dto.interfaces.IRecipeHistory;

import javax.persistence.*;

@Entity
public class RecipeHistory implements IRecipeHistory {
    @Id @GeneratedValue
    @Column(name = "recipe_history_id")
    private int recipeHistId;

    @Override
    public int getRecipeHistId() {
        return recipeHistId;
    }

    @Override
    public void setRecipeHistId(int recipeHistId) {
        this.recipeHistId = recipeHistId;
    }
}
