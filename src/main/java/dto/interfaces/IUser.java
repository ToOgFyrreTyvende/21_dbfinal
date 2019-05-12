package dto.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IUser {
    int getUserId();
    void setUserId(int userId);
    String getUserName();
    void setUserName(String userName);
    String getIni();
    void setIni(String ini);
    String getCpr();
    void setCpr(String cpr);
    String getPassword();
    void setPassword(String password);
    List<IRole> getUserRoles();
    void setUserRoles(List<IRole> userRoles);
    List<IProduct> getUserProducts();
    void setUserProducts(List<IProduct> userProducts);
    void addRole(IRole role);
    boolean removeRole(IRole role);
}
