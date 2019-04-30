package model;

import javax.persistence.*;

@Entity
public class ProductBatch {
    @Id @GeneratedValue
    @Column(name = "product_batch_id")
    private int prodBatchId;
}
