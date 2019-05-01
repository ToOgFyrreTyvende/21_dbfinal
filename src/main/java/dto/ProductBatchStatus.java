package dto;

import dto.interfaces.IProductBatchStatus;
import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
public class ProductBatchStatus implements IProductBatchStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_batch_status_id")
    private int prodBatchStatusId;

    @OneToOne(cascade = CascadeType.ALL)
    @Target(ProductBatch.class)
    @JoinColumn(name = "product_batch_id")
    private ProductBatch productBatch;

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

    public ProductBatch getProductBatch(){
        return productBatch;
    }

    public void setProductBatch(ProductBatch productBatch){
        this.productBatch = productBatch;
    }
}

