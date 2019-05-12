package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IProduct;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RecipePk implements Serializable {
    private IProduct product;
    private IIngredient ingredient;

    @ManyToOne(targetEntity = Product.class)
    public IProduct getProduct(){
        return product;
    }

    public void setProduct(IProduct prod){
        this.product = prod;
    }

    @ManyToOne(targetEntity = Ingredient.class)
    public IIngredient getIngredient(){
        return ingredient;
    }

    public void setIngredient(IIngredient ingr){
        this.ingredient = ingr;
    }
}
