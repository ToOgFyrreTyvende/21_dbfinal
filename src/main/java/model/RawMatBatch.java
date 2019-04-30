package model;

import javax.persistence.*;

@Entity
public class RawMatBatch {
    @Id
    private int batchId;
    private String manufacturerName;
    private double amount;
    private boolean residual;
}
