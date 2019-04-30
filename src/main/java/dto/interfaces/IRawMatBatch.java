package dto.interfaces;

public interface IRawMatBatch {
    int getBatchId();
    void setBatchId(int batchId);
    String getManufacturerName();
    void setManufacturerName(String manufacturerName);
    double getAmount();
    void setAmount(double amount);
    boolean isResidual();
    void setResidual(boolean residual);
}
