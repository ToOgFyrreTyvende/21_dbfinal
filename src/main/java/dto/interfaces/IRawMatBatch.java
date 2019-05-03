package dto.interfaces;

import java.util.Set;

public interface IRawMatBatch {
    int getBatchId();
    void setBatchId(int batchId);
    String getManufacturerName();
    void setManufacturerName(String manufacturerName);
    double getAmount();
    void setAmount(double amount);
    boolean isResidual();
    void setResidual(boolean residual);
    Set<IProductBatch> getRawMatProductBatches();
    void setRawMatProductBatches(Set<IProductBatch> rawMatProductBatches);
    IIngredient getIngredients();
    void setIngredients(IIngredient ingredients);
}
