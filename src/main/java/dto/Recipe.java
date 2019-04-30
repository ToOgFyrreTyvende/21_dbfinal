package dto;

import dal.IRecipe;

import javax.persistence.*;

@Entity
public class Recipe implements IRecipe {
    @Id @GeneratedValue
    @Column(name = "recipe_id")
    private int recipeId;
}
