package dto;

import dto.interfaces.IProductBatch;
import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
@Table(name = "Product_Batch", uniqueConstraints = {
        @UniqueConstraint(columnNames = "product_batch_id")})
public class ProductBatch implements IProductBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_batch_id", unique = true, nullable = false)
    private int prodBatchId;

    @ManyToOne
    @JoinTable(name = "product_batches",
            joinColumns = {@JoinColumn(name = "product_batch_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @Target(ProductBatchStatus.class)
    @JoinColumn(name = "batch_status_id")
    private ProductBatchStatus batchStatus;

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

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public ProductBatchStatus getBatchStatus(){
        return batchStatus;
    }

    public void setBatchStatus(ProductBatchStatus batchStatus){
        this.batchStatus = batchStatus;
    }
}
