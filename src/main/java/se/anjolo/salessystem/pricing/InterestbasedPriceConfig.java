package se.anjolo.salessystem.pricing;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class InterestbasedPriceConfig extends PriceConfig {
    @Setter @Getter
    private double interestRate = 0.0;


    public InterestbasedPriceConfig(UUID offeringId) {
        super(offeringId);
    }

    public InterestbasedPriceConfig(UUID offeringId, String name, String description, LocalDate validFrom, LocalDate validTo,double interestRate) {
        super(offeringId, name, description, validFrom, validTo);
        this.interestRate = interestRate; 
    }
    
}
