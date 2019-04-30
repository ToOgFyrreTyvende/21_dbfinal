package dto;

import dto.interfaces.IIngredient;

import javax.persistence.*;

@Entity
public class Ingredient implements IIngredient {
    @Id @GeneratedValue
    @Column(name = "ingredient_id")
    private int ingredientId;
    private boolean active;

    @Override
    public int getIngredientId() {
        return ingredientId;
    }

    @Override
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
