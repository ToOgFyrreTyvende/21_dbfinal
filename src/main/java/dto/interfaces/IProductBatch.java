package dto.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface IProductBatch {
    int getProdBatchId();
    void setProdBatchId(int prodBatchId);
    IProduct getProduct();
    void setProduct(IProduct product);
    IProductBatchStatus getBatchStatus();
    void setBatchStatus(IProductBatchStatus batchStatus);
    List<IRawMatBatch> getRawMatBatches();
    void setRawMatBatches(List<IRawMatBatch> rawMatBatches);
}
