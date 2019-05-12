package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IProduct;
import dto.interfaces.IRecipe;
import dto.interfaces.IRecipeHistory;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Recipes", indexes = {@Index(columnList = "ingredient_id")})
@AssociationOverrides({
        @AssociationOverride(name = "pk.product",
                joinColumns = @JoinColumn(name = "product_id")),
        @AssociationOverride(name = "pk.ingredient",
                joinColumns = @JoinColumn(name = "ingredient_id"))})
public class Recipe implements IRecipe, Serializable {
    private RecipePk pk = new RecipePk();

    @EmbeddedId
    private RecipePk getPk(){
        return pk;
    }

    private void setPk(RecipePk pk){
        this.pk = pk;
    }

    @Override
    @Transient
    public IProduct getProduct(){
        return getPk().getProduct();
    }

    @Override
    public void setProduct(IProduct product){
        getPk().setProduct(product);
    }

    @Override
    @Transient
    public IIngredient getIngredient(){
        return getPk().getIngredient();
    }

    @Override
    public void setIngredient(IIngredient ingr){
        getPk().setIngredient(ingr);
    }

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "amount", targetEntity = RecipeHistory.class)
    @Column(name = "ingredient_amount", nullable = false)
    private double amount;

    @OneToMany(targetEntity = RecipeHistory.class)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<IRecipeHistory> recipeHistories;

    public Recipe(){
    }

    @Override
    public double getAmount(){
        return amount;
    }

    @Override
    public void setAmount(double amount){
        this.amount = amount;
    }
}
