package dto.interfaces;

import java.util.Set;

public interface IProduct {
    int getProdId();
    void setProdId(int prodId);
    String getProductName();
    void setProductName(String productName);
    Set<IUser> getUsers();
    void setUsers(Set<IUser> users);
    IRecipe getProductRecipe();
    void setProductRecipe(IRecipe productRecipe);
    Set<IProductBatch> getProdBatch();
    void setProdBatch(Set<IProductBatch> prodBatch);
}
