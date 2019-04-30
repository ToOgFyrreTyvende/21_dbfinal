package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductBatchStatus {
    @Id @GeneratedValue
    @Column(name = "product_batch_status_id")
    private int prodBatchStatusId;
}
