package dto.interfaces;

import java.util.List;

public interface IProduct {
    int getProdId();
    void setProdId(int prodId);
    String getProductName();
    void setProductName(String productName);
    List<IUser> getUsers();
    void setUsers(List<IUser> users);
    IRecipe getProductRecipe();
    void setProductRecipe(IRecipe productRecipe);
    List<IProductBatch> getProdBatch();
    void setProdBatch(List<IProductBatch> prodBatch);
}
