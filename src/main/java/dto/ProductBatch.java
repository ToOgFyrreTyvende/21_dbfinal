package dto;

import dto.interfaces.IProductBatch;

import javax.persistence.*;

@Entity
public class ProductBatch implements IProductBatch {
    @Id @GeneratedValue
    @Column(name = "product_batch_id")
    private int prodBatchId;

    @Override
    public int getProdBatchId() {
        return prodBatchId;
    }

    @Override
    public void setProdBatchId(int prodBatchId) {
        this.prodBatchId = prodBatchId;
    }
}
