package dto;

import dto.interfaces.IProductBatch;
import dto.interfaces.IProductBatchStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product_Batch_Status", uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_batch_status_id")})
public class ProductBatchStatus implements IProductBatchStatus, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_batch_status_id")
    private int prodBatchStatusId;

    @Column(name = "status", nullable = false)
    private String prodBatchStatus;

    @OneToOne(mappedBy = "batchStatus",
            targetEntity = ProductBatch.class)
    private IProductBatch productBatch;

    public ProductBatchStatus(){
    }

    @Override
    public int getProdBatchStatusId(){
        return prodBatchStatusId;
    }

    @Override
    public void setProdBatchStatusId(int prodBatchStatusId){
        this.prodBatchStatusId = prodBatchStatusId;
    }

    @Override
    public IProductBatch getProductBatch(){
        return productBatch;
    }

    @Override
    public void setProductBatch(IProductBatch productBatch){
        this.productBatch = productBatch;
    }
}

