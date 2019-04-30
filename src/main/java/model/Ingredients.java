package model;

import javax.persistence.*;

@Entity
public class Ingredients {
    @Id @GeneratedValue
    @Column(name = "ingredient_id")
    private int ingredientId;
    private boolean active;
}
