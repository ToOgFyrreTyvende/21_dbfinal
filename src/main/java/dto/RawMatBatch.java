package dto;

import dto.interfaces.IRawMatBatch;

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

    @Column(name = "manufacturer_name",
            unique = false, nullable = false, length = 80)
    private String manufacturerName;

    @Column(name = "amount",
            unique = false, nullable = false, length = 255)
    private double amount;

    @Column(name = "residual",
            unique = false, nullable = true, length = 255)
    private boolean residual;

    @ManyToMany
    @JoinTable(name = "Product_Batches_Raw_Mat_Batches",
            joinColumns = {@JoinColumn(name = "supplier_batch_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_batch_id")})
    private Set<ProductBatch> rawMatProductBatches;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredients;

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

    public Set<ProductBatch> getRawMatProductBatches(){
        return rawMatProductBatches;
    }

    public void setRawMatProductBatches(Set<ProductBatch> rawMatProductBatches){
        this.rawMatProductBatches = rawMatProductBatches;
    }

    public Ingredient getIngredients(){
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients){
        this.ingredients = ingredients;
    }
}
