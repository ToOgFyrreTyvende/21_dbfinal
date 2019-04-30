package dto;

import dal.IRecipeHistory;

import javax.persistence.*;

@Entity
public class RecipeHistory implements IRecipeHistory {
    @Id @GeneratedValue
    @Column(name = "recipe_history_id")
    private int recipeHistId;
}
