package dto;

import dal.IRawMatBatch;

import javax.persistence.*;

@Entity
public class RawMatBatch implements IRawMatBatch {
    @Id
    private int batchId;
    private String manufacturerName;
    private double amount;
    private boolean residual;
}
