package dto.interfaces;

import java.util.Set;

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
    Set<IRole> getUserRoles();
    void setUserRoles(Set<IRole> userRoles);
    Set<IProduct> getUserProducts();
    void setUserProducts(Set<IProduct> userProducts);
}
