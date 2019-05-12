package dto;

import dto.interfaces.IIngredient;
import dto.interfaces.IProductBatch;
import dto.interfaces.IRawMatBatch;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Raw_Mat_Batches", indexes = {
        @Index(columnList = "ingredient_id")})
public class RawMatBatch implements IRawMatBatch, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id", unique = true, nullable = false)
    private int batchId;

    @Column(name = "supplier_batch_id", nullable = false)
    private int supplierBatchId;

    @Column(name = "supplier_name", nullable = false, length = 80)
    private String supplierName;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "remaining", nullable = false)
    private double remaining;

    @Column(name = "residual", columnDefinition = "BIT DEFAULT 0", nullable = false)
    private boolean residual = false;

    @ManyToMany(targetEntity = ProductBatch.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "Product_Batches_Raw_Mat_Batches",
            joinColumns = {@JoinColumn(name = "supplier_batch_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_batch_id")})
    private List<IProductBatch> rawMatProductBatches = new ArrayList<>();

    @ManyToOne(targetEntity = Ingredient.class)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private IIngredient ingredients;

    public RawMatBatch(){
    }

    @Override
    public int getBatchId(){
        return batchId;
    }

    @Override
    public void setBatchId(int batchId){
        this.batchId = batchId;
    }

    @Override
    public int getSupplierBatchId(){
        return supplierBatchId;
    }

    @Override
    public void setSupplierBatchId(int supplierBatchId){
        this.supplierBatchId = supplierBatchId;
    }

    @Override
    public String getSupplierName(){
        return supplierName;
    }

    @Override
    public void setSupplierName(String supplierName){
        this.supplierName = supplierName;
    }

    @Override
    public double getTotal(){
        return total;
    }

    @Override
    public void setTotal(double total){
        this.total = total;
    }

    @Override
    public double getRemaining(){
        return remaining;
    }

    @Override
    public void setRemaining(double remaining){
        this.remaining = remaining;
    }

    @Override
    public boolean isResidual(){
        return residual;
    }

    @Override
    public void setResidual(boolean residual){
        this.residual = residual;
    }

    @Override
    public List<IProductBatch> getRawMatProductBatches(){
        return rawMatProductBatches;
    }

    @Override
    public void setRawMatProductBatches(List<IProductBatch> rawMatProductBatches){
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
