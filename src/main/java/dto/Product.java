package dto;

import dto.interfaces.IProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product implements IProduct {
    @Id @GeneratedValue
    @Column(name = "product_id")
    private int prodId;

    @Override
    public int getProdId() {
        return prodId;
    }

    @Override
    public void setProdId(int prodId) {
        this.prodId = prodId;
    }
}
