package model;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id @GeneratedValue
    @Column(name = "recipe_id")
    private int recipeId;
}
