package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IProduct;
import dto.interfaces.IRecipe;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Recipes")
@AssociationOverrides({
        @AssociationOverride(name = "pk.product",
                joinColumns = @JoinColumn(name = "product_id")),
        @AssociationOverride(name = "pk.ingredient",
                joinColumns = @JoinColumn(name = "ingredient_id"))
})
public class Recipe implements IRecipe, Serializable {
    private RecipePk pk = new RecipePk();

    @EmbeddedId
    private RecipePk getPk(){
        return pk;
    }

    private void setPk(RecipePk pk){
        this.pk = pk;
    }

    @Transient
    public IProduct getProduct(){
        return getPk().getProduct();
    }

    public void setProduct(IProduct product){
        getPk().setProduct(product);
    }

    @Transient
    public IIngredient getIngredient(){
        return getPk().getIngredient();
    }

    public void setIngredient(IIngredient ingr){
        getPk().setIngredient(ingr);
    }

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "amount", targetEntity = RecipeHistory.class)
    @Column(name = "ingredient_amount", nullable = false)
    private double amount;

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
