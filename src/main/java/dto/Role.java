package dto;

import dto.interfaces.IRole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role", uniqueConstraints = {
        @UniqueConstraint(columnNames = "role_id"),
        @UniqueConstraint(columnNames = "role_name")})
public class Role implements IRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", unique = true, nullable = false)
    private int roleId;

    @Column(name = "role_name", unique = true, nullable = false, length = 25)
    private String roleName;

    @ManyToMany
    Set<User> users;

    public Role(){
    }

    @Override
    public int getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName(){
        return roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public Set<User> getUsers(){
        return users;
    }

    public void setUsers(Set<User> users){
        this.users = users;
    }
}
