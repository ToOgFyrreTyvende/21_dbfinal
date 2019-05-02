package dto;

import dto.interfaces.IIngredient;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Ingredients", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ingredient_id")})
public class Ingredient implements IIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", unique = true, nullable = false)
    private int ingredientId;

    @Column(name = "active", unique = false, nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    private Set<RawMatBatch> recipeRawMatBatch;

    @ManyToMany(mappedBy = "recipeIngredients")
    private Set<Recipe> recipes;

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

    public Set<RawMatBatch> getRecipeRawMatBatch(){
        return recipeRawMatBatch;
    }

    public void setRecipeRawMatBatch(Set<RawMatBatch> recipeRawMatBatch){
        this.recipeRawMatBatch = recipeRawMatBatch;
    }

    public Set<Recipe> getRecipes(){
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes){
        this.recipes = recipes;
    }
}
