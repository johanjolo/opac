package se.anjolo.salessystem.offering;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PriceConfig implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    public enum PaymentInterval {Monthly, Quarterly, Halfyearly, Yearly};  
    String name;
    String description;
    private LocalDate validFrom;
    private LocalDate validTo;

    public PriceConfig() {
    }
   
    public PriceConfig(UUID offeringId) {
    }

    public PriceConfig(String name, String description, LocalDate validFrom, LocalDate validTo) {        
        this.name = name;   
        this.description = description;
        this.validFrom = validFrom;
        this.validTo = validTo;    
      }
}
