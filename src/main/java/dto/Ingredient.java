package dto;

import dto.interfaces.IIngredient;
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
    private List recipeRawMatBatch = new ArrayList();

    @ManyToMany(mappedBy = "recipeIngredients",
            targetEntity = Recipe.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List recipes = new ArrayList();

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
    public List getRecipeRawMatBatch(){
        return recipeRawMatBatch;
    }

    @Override
    public void setRecipeRawMatBatch(ArrayList recipeRawMatBatch){
        this.recipeRawMatBatch = recipeRawMatBatch;
    }

    @Override
    public List getRecipes(){
        return recipes;
    }

    @Override
    public void setRecipes(ArrayList recipes){
        this.recipes = recipes;
    }
}
