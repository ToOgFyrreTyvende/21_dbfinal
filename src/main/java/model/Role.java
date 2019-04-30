package model;

import javax.persistence.*;

@Entity
public class Role {
    @Id @GeneratedValue
    @Column(name = "role_id")
    private int roleId;
}
