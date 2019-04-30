package dto;

import dto.interfaces.IRole;

import javax.persistence.*;

@Entity
public class Role implements IRole {
    @Id @GeneratedValue
    @Column(name = "role_id")
    private int roleId;

    @Override
    public int getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
