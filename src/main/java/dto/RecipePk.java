package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IProduct;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

public class RecipePk implements Serializable {
    private IProduct product;
    private IIngredient ingredient;

    @OneToOne
    public IProduct getProduct(){
        return product;
    }

    public void setProduct(IProduct prod){
        this.product = prod;
    }

    @ManyToOne
    public IIngredient getIngredient(){
        return ingredient;
    }

    public void setIngredient(IIngredient ingr){
        this.ingredient = ingr;
    }
}
