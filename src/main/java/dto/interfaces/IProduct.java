package dto.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IProduct {
    int getProdId();
    void setProdId(int prodId);
    String getProductName();
    void setProductName(String productName);
    List getUsers();
    void setUsers(ArrayList users);
    IRecipe getProductRecipe();
    void setProductRecipe(IRecipe productRecipe);
    List getProdBatch();
    void setProdBatch(ArrayList prodBatch);
}
