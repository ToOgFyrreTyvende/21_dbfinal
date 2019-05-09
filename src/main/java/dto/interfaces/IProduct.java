package dto.interfaces;

import java.util.ArrayList;
import java.util.Collection;

public interface IProduct {
    int getProdId();
    void setProdId(int prodId);
    String getProductName();
    void setProductName(String productName);
    Collection getUsers();
    void setUsers(ArrayList users);
    IRecipe getProductRecipe();
    void setProductRecipe(IRecipe productRecipe);
    Collection getProdBatch();
    void setProdBatch(ArrayList prodBatch);
}
