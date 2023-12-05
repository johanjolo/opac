package se.anjolo.salessystem.shoppingcart;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import se.anjolo.salessystem.offering.OfferingService;

@Service
public class ShoppingcartService {

    Logger logger = LoggerFactory.getLogger(OfferingService.class);

    public ShoppingcartService() {
        logger.info("ShoppingcartService created");
    }

    public ShoppingCart createShoppingCart(UUID customerId) {
        logger.info("Creating shoppingcart for customer {}", customerId);
        return new ShoppingCart(customerId);
    }

    public void executeOfferings(UUID shoppingcartId) {
        logger.info("Executing shoppingcart {}", shoppingcartId);
    
        // TODO: For all items in the shoppingcart
        // TODO: Implement - call instation logic
        // TDOD: Call sales agreement system
    }

}
