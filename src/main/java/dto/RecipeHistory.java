package dto;

import dto.interfaces.IRecipe;
import dto.interfaces.IRecipeHistory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Recipe_History", uniqueConstraints = {
        @UniqueConstraint(columnNames = "recipe_history_id")})
public class RecipeHistory implements IRecipeHistory, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_history_id", unique = true, nullable = false)
    private int recipeHistId;

    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumns({@JoinColumn(name = "ingredient_id", nullable = false),
            @JoinColumn(name = "product_id", nullable = false)})
    private IRecipe recipeHistoryRecipe;

    @Column(name = "action", nullable = false)
    private String action;

    // @ManyToOne(targetEntity = Recipe.class)
    // @JoinColumn(name = "ingredient_amount", nullable = false)
    // private double amount;
    @Column(name = "ingredient_amount", nullable = false)
    private double amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "timestamp", nullable = false)
    private Date timeStamp;

    public RecipeHistory(){
    }

    @Override
    public int getRecipeHistId(){
        return recipeHistId;
    }

    @Override
    public void setRecipeHistId(int recipeHistId){
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

    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action = action;
    }

    public Date getTimeStamp(){
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp){
        this.timeStamp = timeStamp;
    }
}
