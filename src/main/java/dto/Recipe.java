package dto;

import dto.interfaces.IRecipe;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Recipes", uniqueConstraints = {
        @UniqueConstraint(columnNames = "recipe_id")})
public class Recipe implements IRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", unique = true, nullable = false)
    private int recipeId;

    @OneToOne(cascade = CascadeType.ALL)
    @Target(Product.class)
    @JoinColumn(name = "recipe_product_id")
    private Product recipeProduct;

    @OneToMany(mappedBy = "recipeHistoryRecipe", cascade = CascadeType.ALL)
    private Set<RecipeHistory> recipeHistory;

    @ManyToMany
    @JoinTable(name = "Recipes_Ingredients",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<Ingredient> recipeIngredients;

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

    public Product getRecipeProduct(){
        return recipeProduct;
    }

    public void setRecipeProduct(Product recipeProduct){
        this.recipeProduct = recipeProduct;
    }

    public Set<RecipeHistory> getRecipeHistory(){
        return recipeHistory;
    }

    public void setRecipeHistory(Set<RecipeHistory> recipeHistory){
        this.recipeHistory = recipeHistory;
    }

    public Set<Ingredient> getRecipeIngredients(){
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<Ingredient> recipeIngredients){
        this.recipeIngredients = recipeIngredients;
    }
}
