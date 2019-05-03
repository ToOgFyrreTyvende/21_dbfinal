package dto;

import dto.interfaces.IProduct;
import dto.interfaces.IProductBatch;
import dto.interfaces.IRecipe;
import dto.interfaces.IUser;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_id")})
public class Product implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private int prodId;

    @ManyToMany(mappedBy = "userProducts",
            targetEntity = User.class)
    private Set<IUser> users;

    @OneToOne(cascade = CascadeType.ALL,
            targetEntity = Recipe.class)
    @JoinColumn(name = "product_recipe_id", unique = true)
    private IRecipe productRecipe;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
            targetEntity = ProductBatch.class)
    private Set<IProductBatch> prodBatch;

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

    @Override
    public Set<IUser> getUsers(){
        return users;
    }

    @Override
    public void setUsers(Set<IUser> users){
        this.users = users;
    }

    @Override
    public IRecipe getProductRecipe(){
        return productRecipe;
    }

    @Override
    public void setProductRecipe(IRecipe productRecipe){
        this.productRecipe = productRecipe;
    }

    @Override
    public Set<IProductBatch> getProdBatch(){
        return prodBatch;
    }

    @Override
    public void setProdBatch(Set<IProductBatch> prodBatch){
        this.prodBatch = prodBatch;
    }
}
