package se.anjolo.salessystem.pricing;

import lombok.Data;

@Data
public class TransactionVolumeServiceDemand {
    
    private int transactionVolumes;

    public TransactionVolumeServiceDemand(int transactionVolumes) {
        this.transactionVolumes = transactionVolumes;
    }

}
