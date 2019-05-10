package dto;

import dto.interfaces.IProduct;
import dto.interfaces.IRecipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_id")})
public class Product implements IProduct, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private int prodId;

    @Column(name = "product_name")
    private String productName;

    @ManyToMany(mappedBy = "userProducts",
            targetEntity = User.class)
    private List users = new ArrayList();

    @OneToOne(cascade = CascadeType.ALL,
            targetEntity = Recipe.class)
    @JoinColumn(name = "product_recipe_id", unique = true)
    private IRecipe productRecipe;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
            targetEntity = ProductBatch.class)
    private List prodBatch = new ArrayList();

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
    public String getProductName(){
        return productName;
    }

    @Override
    public void setProductName(String productName){
        this.productName = productName;
    }

    @Override
    public List getUsers(){
        return users;
    }

    @Override
    public void setUsers(ArrayList users){
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
    public List getProdBatch(){
        return prodBatch;
    }

    @Override
    public void setProdBatch(ArrayList prodBatch){
        this.prodBatch = prodBatch;
    }
}
