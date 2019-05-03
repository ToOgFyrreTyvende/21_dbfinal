package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IProductBatch;
import dto.interfaces.IRawMatBatch;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Raw_Mat_Batches", uniqueConstraints = {
        @UniqueConstraint(columnNames = "supplier_batch_id")})
public class RawMatBatch implements IRawMatBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_batch_id", unique = true, nullable = false)
    private int batchId;

    @Column(name = "manufacturer_name", nullable = false, length = 80)
    private String manufacturerName;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "residual")
    private boolean residual;

    @ManyToMany(targetEntity = ProductBatch.class)
    @JoinTable(name = "Product_Batches_Raw_Mat_Batches",
            joinColumns = {@JoinColumn(name = "supplier_batch_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_batch_id")})
    private Set<IProductBatch> rawMatProductBatches;

    @ManyToOne(targetEntity = Ingredient.class)
    @JoinColumn(name = "ingredient_id")
    private IIngredient ingredients;

    public RawMatBatch(){
    }

    @Override
    public int getBatchId() {
        return batchId;
    }

    @Override
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    @Override
    public String getManufacturerName() {
        return manufacturerName;
    }

    @Override
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean isResidual() {
        return residual;
    }

    @Override
    public void setResidual(boolean residual) {
        this.residual = residual;
    }

    @Override
    public Set<IProductBatch> getRawMatProductBatches(){
        return rawMatProductBatches;
    }

    @Override
    public void setRawMatProductBatches(Set<IProductBatch> rawMatProductBatches){
        this.rawMatProductBatches = rawMatProductBatches;
    }

    @Override
    public IIngredient getIngredients(){
        return ingredients;
    }

    @Override
    public void setIngredients(IIngredient ingredients){
        this.ingredients = ingredients;
    }
}
