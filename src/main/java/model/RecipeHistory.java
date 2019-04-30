package model;

import javax.persistence.*;

@Entity
public class RecipeHistory {
    @Id @GeneratedValue
    @Column(name = "recipe_history_id")
    private int recipeHistId;
}
