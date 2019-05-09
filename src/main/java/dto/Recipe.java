package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IProduct;
import dto.interfaces.IRecipe;
import dto.interfaces.IRecipeHistory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Recipes", uniqueConstraints = {
        @UniqueConstraint(columnNames = "recipe_id")})
public class Recipe implements IRecipe, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", unique = true, nullable = false)
    private int recipeId;

    @OneToOne(mappedBy = "productRecipe",
            targetEntity = Product.class)
    private IProduct recipeProduct;

    @OneToMany(mappedBy = "recipeHistoryRecipe", cascade = CascadeType.ALL,
            targetEntity = RecipeHistory.class)
    private Set<IRecipeHistory> recipeHistory;

    @ManyToMany(targetEntity = Ingredient.class)
    @JoinTable(name = "Recipes_Ingredients",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<IIngredient> recipeIngredients;

    public Recipe(){
    }

    @Override
    public int getRecipeId(){
        return recipeId;
    }

    @Override
    public void setRecipeId(int recipeId){
        this.recipeId = recipeId;
    }

    @Override
    public IProduct getRecipeProduct(){
        return recipeProduct;
    }

    @Override
    public void setRecipeProduct(IProduct recipeProduct){
        this.recipeProduct = recipeProduct;
    }

    @Override
    public Set<IRecipeHistory> getRecipeHistory(){
        return recipeHistory;
    }

    @Override
    public void setRecipeHistory(Set<IRecipeHistory> recipeHistory){
        this.recipeHistory = recipeHistory;
    }

    @Override
    public Set<IIngredient> getRecipeIngredients(){
        return recipeIngredients;
    }

    @Override
    public void setRecipeIngredients(Set<IIngredient> recipeIngredients){
        this.recipeIngredients = recipeIngredients;
    }
}
