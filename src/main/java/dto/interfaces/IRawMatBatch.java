package dto.interfaces;

import java.util.ArrayList;
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
    List getRawMatProductBatches();
    void setRawMatProductBatches(ArrayList rawMatProductBatches);
    IIngredient getIngredients();
    void setIngredients(IIngredient ingredients);
}
