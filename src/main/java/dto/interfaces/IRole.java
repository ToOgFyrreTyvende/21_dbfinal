package dto.interfaces;

import java.util.ArrayList;
import java.util.Collection;

public interface IRole {

    int getRoleId();
    void setRoleId(int roleId);
    String getRoleName();
    void setRoleName(String roleName);
    Collection getUsers();
    void setUsers(ArrayList users);
}
