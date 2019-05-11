package dto;

import dto.interfaces.IProduct;
import dto.interfaces.IRecipe;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List recipeHistory = new ArrayList();

    @ManyToMany(targetEntity = Ingredient.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "Recipes_Ingredients",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private List recipeIngredients = new ArrayList();

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
    public List getRecipeHistory(){
        return recipeHistory;
    }

    @Override
    public void setRecipeHistory(ArrayList recipeHistory){
        this.recipeHistory = recipeHistory;
    }

    @Override
    public List getRecipeIngredients(){
        return recipeIngredients;
    }

    @Override
    public void setRecipeIngredients(ArrayList recipeIngredients){
        this.recipeIngredients = recipeIngredients;
    }
}
