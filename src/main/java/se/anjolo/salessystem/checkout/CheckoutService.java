package se.anjolo.salessystem.checkout;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.anjolo.salessystem.agreement.Agreement;
import se.anjolo.salessystem.agreement.AgreementService;
import se.anjolo.salessystem.offering.PriceConfig;

@Service
public class CheckoutService {
    Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    @Autowired
    AgreementService agreementService;

    public Agreement checkout(UUID offeringId, PriceConfig priceConfig) {
        logger.info("Checking out {} with price {}", offeringId, priceConfig);

        // Offering offering = new Offering();

        // TODO: Implement - call instation logic

        // TDOD: Call sales agreement system
        UUID customerId = UUID.randomUUID();
        Agreement agreement = agreementService.createAgreement(offeringId, customerId, priceConfig);

        return agreement;
    }

    public List<Agreement> checkout(UUID shoppingCartId) {
        logger.info("Checking out shoppingcart {} ", shoppingCartId);

        // TODO: Implement - call instation logic
        // TDOD: Call sales agreement system

        return null;
    }

}
