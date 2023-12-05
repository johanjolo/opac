package se.anjolo.salessystem.shoppingcart;

import java.util.List;
import java.util.UUID;

import org.javatuples.Pair;

import lombok.Data;
import se.anjolo.salessystem.offering.Offering;
import se.anjolo.salessystem.pricing.PriceConfig;

@Data
public class ShoppingCart {
    private UUID shoppingCartId;
    private UUID customerId;
    private List<Pair<Offering, PriceConfig>> offerings;

    public ShoppingCart(UUID customerId) {
        this.customerId = customerId;
        offerings = new java.util.ArrayList<Pair<Offering, PriceConfig>>();    
        shoppingCartId = UUID.randomUUID();
    }

public Offering addOffering(UUID offeringId, PriceConfig priceConfig) {
Pair<Offering, PriceConfig> offerings = new Pair<Offering,PriceConfig>(null, null);
    Offering offering = null; //new Offering(offeringId, priceConfig.getPriceConfig());
        offerings.add(offering);
        return offering;        
}


}
