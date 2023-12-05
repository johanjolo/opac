package se.anjolo.salessystem.agreement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.UUID;

import se.anjolo.salessystem.pricing.PriceConfig;

@Service
public class AgreementService {
        Logger logger = LoggerFactory.getLogger(AgreementService.class);
    
    public Agreement createAgreement(UUID offeringId, UUID customerId, PriceConfig priceConfig) {
        logger.info("Creating agreement for oppering: {} with priceconfig: {}", offeringId, priceConfig);
        
        Agreement agreement = new Agreement(offeringId, customerId, priceConfig);
     
        return agreement;
    }

}
