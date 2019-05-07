package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IRawMatBatch;
import dto.interfaces.IRecipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Ingredients", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ingredient_id")})
public class Ingredient implements IIngredient, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", unique = true, nullable = false)
    private int ingredientId;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "ingredients", cascade = CascadeType.ALL,
            targetEntity = RawMatBatch.class)
    private Set<IRawMatBatch> recipeRawMatBatch;

    @ManyToMany(mappedBy = "recipeIngredients",
            targetEntity = Recipe.class)
    private Set<IRecipe> recipes;

    public Ingredient(){
    }

    @Override
    public int getIngredientId() {
        return ingredientId;
    }

    @Override
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public Set<IRawMatBatch> getRecipeRawMatBatch(){
        return recipeRawMatBatch;
    }

    @Override
    public void setRecipeRawMatBatch(Set<IRawMatBatch> recipeRawMatBatch){
        this.recipeRawMatBatch = recipeRawMatBatch;
    }

    @Override
    public Set<IRecipe> getRecipes(){
        return recipes;
    }

    @Override
    public void setRecipes(Set<IRecipe> recipes){
        this.recipes = recipes;
    }
}
