package dto;

import dto.interfaces.IRecipe;
import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
@Table(name = "Recipe", uniqueConstraints = {
        @UniqueConstraint(columnNames = "recipe_id")})
public class Recipe implements IRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", unique = true, nullable = false)
    private int recipeId;

    @OneToOne(cascade = CascadeType.ALL)
    @Target(Product.class)
    @JoinColumn(name = "recipe_product_id")
    private Product recipeProduct;

    public Recipe(){
    }

    @Override
    public int getRecipeId(){
        return recipeId;
    }

    @Override
    public void setRecipeId(int recipeId){
        this.recipeId = recipeId;
    }

    public Product getRecipeProduct(){
        return recipeProduct;
    }

    public void setRecipeProduct(Product recipeProduct){
        this.recipeProduct = recipeProduct;
    }
}
