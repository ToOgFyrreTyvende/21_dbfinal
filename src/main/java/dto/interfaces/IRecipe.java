package dto.interfaces;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

public interface IRecipe {

    @Transient
    IProduct getProduct();
    void setProduct(IProduct product);
    @Transient
    IIngredient getIngredient();
    void setIngredient(IIngredient ingr);
    double getAmount();
    void setAmount(double amount);

}
