package dto;

import dto.interfaces.IRecipe;

import javax.persistence.*;

@Entity
public class Recipe implements IRecipe {
    @Id @GeneratedValue
    @Column(name = "recipe_id")
    private int recipeId;

    @Override
    public int getRecipeId() {
        return recipeId;
    }

    @Override
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
