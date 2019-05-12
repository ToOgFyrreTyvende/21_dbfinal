package dto;

import dto.interfaces.IProduct;
import dto.interfaces.IRecipe;
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
    private List users = new ArrayList();

    // @OneToOne(cascade = CascadeType.ALL,
    //         targetEntity = Recipe.class)
    // @JoinColumn(name = "product_recipe_id", unique = true)
    // private IRecipe productRecipe;

    @OneToMany(fetch = FetchType.LAZY, )
    private List<IRecipe> recipe = new ArrayList<>();

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
    public List getUsers(){
        return users;
    }

    @Override
    public void setUsers(ArrayList users){
        this.users = users;
    }

    // @Override
    // public IRecipe getProductRecipe(){
    //     return productRecipe;
    // }
    //
    // @Override
    // public void setProductRecipe(IRecipe productRecipe){
    //     this.productRecipe = productRecipe;
    // }

    @Override
    public List getProdBatch(){
        return prodBatch;
    }

    @Override
    public void setProdBatch(ArrayList prodBatch){
        this.prodBatch = prodBatch;
    }
}
