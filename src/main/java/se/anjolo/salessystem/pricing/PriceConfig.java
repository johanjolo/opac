package se.anjolo.salessystem.pricing;

import java.util.UUID;

import lombok.Data;
import java.time.LocalDate;

@Data
abstract public class PriceConfig {
    UUID priceConfigId;
    UUID offeringId;

    public static enum PaymentInterval {Monthly, Quarterly, Halfyearly, Yearly};  
    String name;
    String description;
    private LocalDate validFrom;
    private LocalDate validTo;

    public PriceConfig(UUID offeringId) {
        priceConfigId = UUID.randomUUID();
        this.offeringId = offeringId;   
    }

    public PriceConfig(UUID offeringId, String name, String description, LocalDate validFrom, LocalDate validTo) {        
        priceConfigId = UUID.randomUUID();
        this.offeringId = offeringId;
        this.name = name;   
        this.description = description;
        this.validFrom = validFrom;
        this.validTo = validTo;    }
}
