package dto;

import dal.IProductBatch;

import javax.persistence.*;

@Entity
public class ProductBatch implements IProductBatch {
    @Id @GeneratedValue
    @Column(name = "product_batch_id")
    private int prodBatchId;
}
