package dto.interfaces;

public interface IProductBatchStatus {

    int getProdBatchStatusId();
    void setProdBatchStatusId(int prodBatchStatusId);
    IProductBatch getProductBatch();
    void setProductBatch(IProductBatch productBatch);
}
