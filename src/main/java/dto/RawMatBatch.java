package dto;

import dto.interfaces.IRawMatBatch;

import javax.persistence.*;

@Entity
public class RawMatBatch implements IRawMatBatch {
    @Id
    private int batchId;
    private String manufacturerName;
    private double amount;
    private boolean residual;

    @Override
    public int getBatchId() {
        return batchId;
    }

    @Override
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    @Override
    public String getManufacturerName() {
        return manufacturerName;
    }

    @Override
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean isResidual() {
        return residual;
    }

    @Override
    public void setResidual(boolean residual) {
        this.residual = residual;
    }
}
