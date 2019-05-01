package dto;

import dto.interfaces.IProduct;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Product", uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_id")})
public class Product implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private int prodId;

    @OneToOne(cascade = CascadeType.ALL)
    @Target(Recipe.class)
    @JoinColumn(name = "product_recipe_id")
    private Recipe productRecipe;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_batches",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_batch_id")})
    private Set<ProductBatch> prodBatch;

    public Product(){
    }

    @Override
    public int getProdId(){
        return prodId;
    }

    @Override
    public void setProdId(int prodId){
        this.prodId = prodId;
    }

    public Recipe getProductRecipe(){
        return productRecipe;
    }

    public void setProductRecipe(Recipe productRecipe){
        this.productRecipe = productRecipe;
    }

    public Set<ProductBatch> getProdBatch(){
        return prodBatch;
    }

    public void setProdBatch(Set<ProductBatch> prodBatch){
        this.prodBatch = prodBatch;
    }
}
