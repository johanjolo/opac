package se.anjolo.salessystem.offering;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import se.anjolo.salessystem.pricing.DiscountStructure;
import se.anjolo.salessystem.pricing.PriceConfig;

// @Entity
@Data
public class Offering {
    
 /*    @Id
    @GeneratedValue(strategy = GenerationType.UUID) */
    private UUID id;
    
    
    private String name;
    private String description;
    private LocalDate validFrom;
    private LocalDate validTo;
    
    //listprice and a discount structure
    private PriceConfig listprice;
    private DiscountStructure discountStructure;

    // list of alternative price configurations, e.g campaign prices
    @Getter
    private List<PriceConfig> priceConfigurations;
    
    // The offeringInstantiator is the class that knows how to instantiate the offering
    private OfferingInstantiator offeringInstantiator;

    public Offering(String name, String description, LocalDate validFrom, LocalDate validTo) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Offering() {
        this.id = UUID.randomUUID();
    }


    public void addPriceConfig(PriceConfig priceConfig) {
        priceConfigurations.add(priceConfig);
    }

    public void removePriceConfig(PriceConfig priceConfig) {
        priceConfigurations.remove(priceConfig);
    }
}
