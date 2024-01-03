package se.anjolo.salessystem.agreement;

import java.util.UUID;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import se.anjolo.salessystem.SalesSystemDB;
import se.anjolo.salessystem.pricing.PriceConfig;

@Service
public class AgreementService {
        Logger logger = LoggerFactory.getLogger(AgreementService.class);
    
    public Agreement createAgreement(UUID offeringId, UUID customerId, PriceConfig priceConfig) {
        logger.info("Creating agreement for oppering: {} with priceconfig: {}", offeringId, priceConfig);
        
        Agreement agreement = new Agreement(offeringId, customerId, priceConfig);
        SalesSystemDB.getInstance().addAgreement(customerId, agreement);

        return agreement;
    }


    public List<Agreement> getAgreements(UUID customerId) {
        logger.info("Getting agreements for customer: {}", customerId);
        return SalesSystemDB.getInstance().getAgreements(customerId);
    }

}
