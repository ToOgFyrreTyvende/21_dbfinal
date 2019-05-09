package dto.interfaces;

import java.util.List;

public interface IRole {

    int getRoleId();
    void setRoleId(int roleId);
    String getRoleName();
    void setRoleName(String roleName);
    List<IUser> getUsers();
    void setUsers(List<IUser> users);
}
