package dto;

import dal.IRole;

import javax.persistence.*;

@Entity
public class Role implements IRole {
    @Id @GeneratedValue
    @Column(name = "role_id")
    private int roleId;
}
