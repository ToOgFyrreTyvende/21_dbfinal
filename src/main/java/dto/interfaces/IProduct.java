package dto.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IProduct {
    int getProdId();
    void setProdId(int prodId);
    String getProductName();
    void setProductName(String productName);
    double getYield();
    void setYield(double yield);
    double getShelfTime();
    void setShelfTime(double shelfTime);
    List<IUser> getUsers();
    void setUsers(List<IUser> users);
    List<IRecipe> getRecipes();
    void setRecipes(List<IRecipe> recipes);
    List<IProductBatch> getProdBatch();
    void setProdBatch(List<IProductBatch> prodBatch);
}
