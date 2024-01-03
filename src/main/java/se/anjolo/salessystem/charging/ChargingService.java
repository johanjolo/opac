package se.anjolo.salessystem.charging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.anjolo.salessystem.agreement.AgreementService;

import java.util.UUID;


@Service
public class ChargingService {
    
    Logger logger = LoggerFactory.getLogger(ChargingService.class);

    @Autowired
    AgreementService agreementService;

    public ChargingService() {
        logger.info("ChargingService created");
    }


    /**
     * Charge the customer for the offering
     * 
     * @param agreementId
     * @param customerId
     * @return the PriceConfig with best price for the offering giving the
     *         customer's expected volumes
     */
    public void chargeCustomer(UUID customerId) {
        logger.info("Charge customer: {}", customerId);

        agreementService.getAgreements(customerId).forEach(agreement -> {
            logger.info("Charging customer: {} for agreement: {}", customerId, agreement);
        }); 
    }
}
