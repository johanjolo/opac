package se.anjolo.salessystem.agreement;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import se.anjolo.salessystem.offering.PriceConfig;  


@Data
@Entity
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID agreementId;
    
    private UUID offeringId;    
    private UUID customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agreedprice_id", referencedColumnName = "id")
    private PriceConfig agreedPrice;

    public Agreement(UUID offeringId, UUID customerId, PriceConfig priceConfig) {
        this.offeringId = offeringId;
        this.customerId = customerId;
        this.agreedPrice = priceConfig;
    }
}
