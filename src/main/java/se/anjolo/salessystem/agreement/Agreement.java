package se.anjolo.salessystem.agreement;

import java.util.UUID;

import lombok.Data;
import se.anjolo.salessystem.offering.PriceConfig;  


@Data
public class Agreement {
    UUID agreementId;
    UUID offeringId;
    UUID customerId;
    PriceConfig priceConfig;

    public Agreement(UUID offeringId, UUID customerId, PriceConfig priceConfig) {
        agreementId = UUID.randomUUID();
        this.offeringId = offeringId;
        this.customerId = customerId;
        this.priceConfig = priceConfig;
    }
}
