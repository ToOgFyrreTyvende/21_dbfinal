package dto;

import dto.interfaces.IProduct;
import dto.interfaces.IProductBatch;
import dto.interfaces.IProductBatchStatus;
import dto.interfaces.IRawMatBatch;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product_Batches", uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_batch_id")})
public class ProductBatch implements IProductBatch, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_batch_id", unique = true, nullable = false)
    private int prodBatchId;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id", nullable = false)
    private IProduct product;

    @OneToOne(cascade = CascadeType.ALL,
            targetEntity = ProductBatchStatus.class)
    @JoinColumn(name = "batch_status_id", unique = true, nullable = false)
    private IProductBatchStatus batchStatus;

    @ManyToMany(targetEntity = RawMatBatch.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "Product_Batches_Raw_Mat_Batches",
            joinColumns = {@JoinColumn(name = "product_batch_id")},
            inverseJoinColumns = {@JoinColumn(name = "supplier_batch_id")})
    private List<IRawMatBatch> rawMatBatches = new ArrayList<>();

    public ProductBatch(){
    }

    @Override
    public int getProdBatchId(){
        return prodBatchId;
    }

    @Override
    public void setProdBatchId(int prodBatchId){
        this.prodBatchId = prodBatchId;
    }

    @Override
    public IProduct getProduct(){
        return product;
    }

    @Override
    public void setProduct(IProduct product){
        this.product = product;
    }

    @Override
    public IProductBatchStatus getBatchStatus(){
        return batchStatus;
    }

    @Override
    public void setBatchStatus(IProductBatchStatus batchStatus){
        this.batchStatus = batchStatus;
    }

    @Override
    public List<IRawMatBatch> getRawMatBatches(){
        return rawMatBatches;
    }

    @Override
    public void setRawMatBatches(List<IRawMatBatch> rawMatBatches){
        this.rawMatBatches = rawMatBatches;
    }
}
