package dto;

import dal.IIngredient;

import javax.persistence.*;

@Entity
public class Ingredient implements IIngredient {
    @Id @GeneratedValue
    @Column(name = "ingredient_id")
    private int ingredientId;
    private boolean active;
}
