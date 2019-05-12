package dto.interfaces;

import java.util.List;

public interface IRawMatBatch {
    int getBatchId();
    void setBatchId(int batchId);
    int getSupplierBatchId();
    void setSupplierBatchId(int supplierBatchId);
    String getSupplierName();
    void setSupplierName(String supplierName);
    double getTotal();
    void setTotal(double total);
    double getRemaining();
    void setRemaining(double remaining);
    boolean isResidual();
    void setResidual(boolean residual);
    List getRawMatProductBatches();
    void setRawMatProductBatches(List rawMatProductBatches);
    IIngredient getIngredients();
    void setIngredients(IIngredient ingredients);
}
