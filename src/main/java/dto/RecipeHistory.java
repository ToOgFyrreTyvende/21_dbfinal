package dto;

import dto.interfaces.IRecipe;
import dto.interfaces.IRecipeHistory;
import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
@Table(name = "Recipe_History", uniqueConstraints = {
        @UniqueConstraint(columnNames = "recipe_history_id")})
public class RecipeHistory implements IRecipeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_history_id", unique = true, nullable = false)
    private int recipeHistId;

    // @Target(Recipe.class)
    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name = "recipe_id")
    private IRecipe recipeHistoryRecipe;

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

    @Override
    public IRecipe getRecipeHistoryRecipe(){
        return recipeHistoryRecipe;
    }

    @Override
    public void setRecipeHistoryRecipe(IRecipe recipeHistoryRecipe){
        this.recipeHistoryRecipe = recipeHistoryRecipe;
    }
}
