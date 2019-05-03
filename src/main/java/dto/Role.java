package dto;

import dto.interfaces.IRole;
import dto.interfaces.IUser;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "role_id"),
        @UniqueConstraint(columnNames = "role_name")})
public class Role implements IRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", unique = true, nullable = false)
    private int roleId;

    @Column(name = "role_name", unique = true, nullable = false, length = 25)
    private String roleName;

    // @Target(User.class)
    @ManyToMany(mappedBy = "userRoles",
            targetEntity = User.class)
    private Set<IUser> users;

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

    @Override
    public String getRoleName(){
        return roleName;
    }

    @Override
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    @Override
    public Set<IUser> getUsers(){
        return users;
    }

    @Override
    public void setUsers(Set<IUser> users){
        this.users = users;
    }
}
