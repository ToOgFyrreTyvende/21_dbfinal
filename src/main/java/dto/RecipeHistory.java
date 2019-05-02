package dto;

import dto.interfaces.IRecipeHistory;

import javax.persistence.*;

@Entity
@Table(name = "Recipe_History", uniqueConstraints = {
        @UniqueConstraint(columnNames = "recipe_history_id")})
public class RecipeHistory implements IRecipeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_history_id", unique = true, nullable = false)
    private int recipeHistId;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipeHistoryRecipe;

    public RecipeHistory(){
    }

    @Override
    public int getRecipeHistId() {
        return recipeHistId;
    }

    @Override
    public void setRecipeHistId(int recipeHistId) {
        this.recipeHistId = recipeHistId;
    }

    public Recipe getRecipeHistoryRecipe(){
        return recipeHistoryRecipe;
    }

    public void setRecipeHistoryRecipe(Recipe recipeHistoryRecipe){
        this.recipeHistoryRecipe = recipeHistoryRecipe;
    }
}
