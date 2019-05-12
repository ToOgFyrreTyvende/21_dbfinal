package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IRawMatBatch;
import dto.interfaces.IRecipe;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ingredients", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ingredient_id")})
public class Ingredient implements IIngredient, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", unique = true, nullable = false)
    private int ingredientId;

    @Column(name = "ingredient_name", unique = true, nullable = false)
    private String ingredientName;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "ingredients", cascade = CascadeType.ALL,
            targetEntity = RawMatBatch.class)
    private List<IRawMatBatch> recipeRawMatBatch = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.ingredient",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Recipe.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<IRecipe> recipes = new ArrayList<>();

    public Ingredient(){
        this.active = false;
    }

    @Override
    public int getIngredientId(){
        return ingredientId;
    }

    @Override
    public void setIngredientId(int ingredientId){
        this.ingredientId = ingredientId;
    }

    @Override
    public String getIngredientName(){
        return ingredientName;
    }

    @Override
    public void setIngredientName(String ingredientName){
        this.ingredientName = ingredientName;
    }

    @Override
    public boolean isActive(){
        return active;
    }

    @Override
    public void setActive(boolean active){
        this.active = active;
    }

    @Override
    public List<IRawMatBatch> getRecipeRawMatBatch(){
        return recipeRawMatBatch;
    }

    @Override
    public void setRecipeRawMatBatch(List<IRawMatBatch> recipeRawMatBatch){
        this.recipeRawMatBatch = recipeRawMatBatch;
    }

    @Override
    public List<IRecipe> getRecipes(){
        return this.recipes;
    }

    @Override
    public void setRecipes(List<IRecipe> newRecipes){
        this.recipes = newRecipes;
    }
}
