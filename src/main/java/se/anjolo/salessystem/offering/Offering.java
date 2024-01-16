package se.anjolo.salessystem.offering;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Offering {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID offeringId;

    private String name;
    private String description;
    private LocalDate validFrom;
    private LocalDate validTo;

    // listprice and a discount structure
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "listprice_id", referencedColumnName = "id")
    private PriceConfig listprice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discountstructure_id", referencedColumnName = "id")
    private DiscountStructure discountStructure;

    // list of alternative price configurations, e.g campaign prices
    
    @OneToMany(targetEntity=PriceConfig.class,cascade = CascadeType.ALL, 
    fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PriceConfig> priceConfigurations = new java.util.ArrayList<PriceConfig>();

    // The offeringInstantiator is the class that knows how to instantiate the
    // offering
    
    private String offeringInstantiator;

    public Offering() {
        // this.offeringId = UUID.randomUUID();
    }


    public Offering(String name, String description, LocalDate validFrom, LocalDate validTo) {
        // this.offeringId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Offering(String name, String description, LocalDate validFrom, LocalDate validTo, PriceConfig listprice,
            DiscountStructure discountStructure) {
        // this.offeringId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.listprice = listprice;
        this.discountStructure = discountStructure;
    }
 
    public void addPriceConfig(PriceConfig priceConfig) {
        priceConfigurations.add(priceConfig);
    }

    public void removePriceConfig(PriceConfig priceConfig) {
        priceConfigurations.remove(priceConfig);
    }

    public String toString() {
        return "Offering: " + name + " " + description + " " + validFrom + " " + validTo + " " + listprice + " "
                + discountStructure + " " + priceConfigurations;
    }    
    
}
