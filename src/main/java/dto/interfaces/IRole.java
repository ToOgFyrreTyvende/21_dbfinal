package dto.interfaces;

import java.util.Set;

public interface IRole {

    int getRoleId();
    void setRoleId(int roleId);
    String getRoleName();
    void setRoleName(String roleName);
    Set<IUser> getUsers();
    void setUsers(Set<IUser> users);
}
