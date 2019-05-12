package dto;

import dto.interfaces.IProduct;
import dto.interfaces.IProductBatch;
import dto.interfaces.IRecipe;
import dto.interfaces.IUser;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name = "product_yield", nullable = false)
    private double yield;

    @Column(name = "shelf_time", nullable = false)
    private double shelfTime;

    @ManyToMany(mappedBy = "userProducts",
            targetEntity = User.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<IUser> users = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = Recipe.class)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<IRecipe> recipes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
            targetEntity = ProductBatch.class)
    private List<IProductBatch> prodBatch = new ArrayList<>();

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
    public double getYield(){
        return yield;
    }

    @Override
    public void setYield(double yield){
        this.yield = yield;
    }

    @Override
    public double getShelfTime(){
        return shelfTime;
    }

    @Override
    public void setShelfTime(double shelfTime){
        this.shelfTime = shelfTime;
    }

    @Override
    public List<IUser> getUsers(){
        return users;
    }

    @Override
    public void setUsers(List<IUser> users){
        this.users = users;
    }

    @Override
    public List<IRecipe> getRecipes(){
        return recipes;
    }

    @Override
    public void setRecipes(List<IRecipe> recipes){
        this.recipes = recipes;
    }

    @Override
    public List<IProductBatch> getProdBatch(){
        return prodBatch;
    }

    @Override
    public void setProdBatch(List<IProductBatch> prodBatch){
        this.prodBatch = prodBatch;
    }
}
