package dto.interfaces;

import java.util.List;

public interface IRawMatBatch {
    int getBatchId();
    void setBatchId(int batchId);
    String getManufacturerName();
    void setManufacturerName(String manufacturerName);
    double getAmount();
    void setAmount(double amount);
    boolean isResidual();
    void setResidual(boolean residual);
    List<IProductBatch> getRawMatProductBatches();
    void setRawMatProductBatches(List<IProductBatch> rawMatProductBatches);
    IIngredient getIngredients();
    void setIngredients(IIngredient ingredients);
}
