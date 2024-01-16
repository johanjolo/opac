package se.anjolo.salessystem.offering;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class InterestbasedPriceConfig extends PriceConfig {
    @Setter @Getter
    private double interestRate = 0.0;

    public InterestbasedPriceConfig() {
        super();
    }

    public InterestbasedPriceConfig( String name, String description, LocalDate validFrom, LocalDate validTo,double interestRate) {
        //super(name, description, validFrom, validTo);
        this.interestRate = interestRate; 
    }
    
}
