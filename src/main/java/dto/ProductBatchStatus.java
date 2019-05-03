package dto;

import dto.interfaces.IProductBatch;
import dto.interfaces.IProductBatchStatus;
import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
@Table(name = "Product_Batch_Status", uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_batch_status_id")})
public class ProductBatchStatus implements IProductBatchStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_batch_status_id")
    private int prodBatchStatusId;

    // @JoinColumn(name = "product_batch_id", unique = true)
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

