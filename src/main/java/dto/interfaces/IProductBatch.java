package dto.interfaces;

import java.util.Set;

public interface IProductBatch {
    int getProdBatchId();
    void setProdBatchId(int prodBatchId);
    IProduct getProduct();
    void setProduct(IProduct product);
    IProductBatchStatus getBatchStatus();
    void setBatchStatus(IProductBatchStatus batchStatus);
    Set<IRawMatBatch> getRawMatBatches();
    void setRawMatBatches(Set<IRawMatBatch> rawMatBatches);
}
