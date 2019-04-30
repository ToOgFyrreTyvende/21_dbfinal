package dto;

import dto.interfaces.IProductBatchStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductBatchStatus implements IProductBatchStatus {
    @Id @GeneratedValue
    @Column(name = "product_batch_status_id")
    private int prodBatchStatusId;

    @Override
    public int getProdBatchStatusId() {
        return prodBatchStatusId;
    }

    @Override
    public void setProdBatchStatusId(int prodBatchStatusId) {
        this.prodBatchStatusId = prodBatchStatusId;
    }
}

