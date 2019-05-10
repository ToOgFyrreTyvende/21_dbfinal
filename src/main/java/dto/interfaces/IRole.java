package dto.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IRole {

    int getRoleId();
    void setRoleId(int roleId);
    String getRoleName();
    void setRoleName(String roleName);
    List getUsers();
    void setUsers(ArrayList users);
}
