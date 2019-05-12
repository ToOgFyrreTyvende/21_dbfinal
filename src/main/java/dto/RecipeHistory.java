package dto;

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

    @Column(name = "ingredient_id", nullable = false)
    private int ingredientId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "ingredient_amount", nullable = false)
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
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
    public int getIngredientId(){
        return ingredientId;
    }

    @Override
    public void setIngredientId(int ingredientId){
        this.ingredientId = ingredientId;
    }

    @Override
    public int getProductId(){
        return productId;
    }

    @Override
    public void setProductId(int productId){
        this.productId = productId;
    }

    @Override
    public String getAction(){
        return action;
    }

    @Override
    public void setAction(String action){
        this.action = action;
    }

    @Override
    public double getAmount(){
        return amount;
    }

    @Override
    public void setAmount(double amount){
        this.amount = amount;
    }

    @Override
    public Date getTimeStamp(){
        return timeStamp;
    }

    @Override
    public void setTimeStamp(Date timeStamp){
        this.timeStamp = timeStamp;
    }
}
