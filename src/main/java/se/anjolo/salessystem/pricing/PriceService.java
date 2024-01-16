package se.anjolo.salessystem.pricing;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.anjolo.salessystem.offering.Offering;
import se.anjolo.salessystem.offering.OfferingRepository;
import se.anjolo.salessystem.offering.PriceConfig;

@Service
public class PriceService {

    Logger logger = LoggerFactory.getLogger(PriceService.class);
	
    @Autowired
	OfferingRepository offeringRepository;

    public PriceService() {
        logger.info("PriceService created");
    }


    /**
     * Get the right price for the selceted offering
     * 
     * @param offeringid
     * @param customerId
     * @param transactionVolumeServiceDemand
     * @return the PriceConfig with best price for the offering giving the
     *         customer's expected volumes
     */
    public PriceConfig getPrice(UUID offeringid, UUID customerId,
            TransactionVolumeServiceDemand transactionVolumeServiceDemand) {
        logger.info("Price reguested for offering: {} for customer: {} with expected volumes: {}", offeringid,
                customerId, transactionVolumeServiceDemand.getTransactionVolumes());

            Offering offering;
        // List<SubscriptionPriceConfig> configs = this.getPriceConfigsForOffering(offeringid);
        Optional optional  = offeringRepository.findById(offeringid);
        if (!optional.isPresent()) {
                offering = (Offering) optional.get();
        } else {
            logger.error("No offering found for id: {}", offeringid);
            return null;
        }

        /*if (configs.size() == 0) {
            logger.error("No price configuration found for offering: {}", offeringid);
            return null;
        }
*/
/* 
        SubscriptionPriceConfig configToReturn = null;
        double lowestPrice = Double.MAX_VALUE;
        for (SubscriptionPriceConfig priceConfig : configs) { // loop through all configs for the offering
            double price = priceConfig.getPrice()
                    + transactionVolumeServiceDemand.getTransactionVolumes() * priceConfig.getTransactionPrice();
            if (price < lowestPrice) {
                lowestPrice = price;
                configToReturn = priceConfig;
            }
        }
*/
        // return listprice 
        return offering.getListprice();
    }

    /* 
    public PriceConfig addPriceConfig(UUID offeringId, PriceConfig priceConfig) {
        // TODO add priceconfig to database

        return priceConfig;
    }
    */

    public PriceConfig getPriceConfig(UUID priceConfigId) {
        // TODO get priceconfig from database

        return null;
    }

/*
    public List<SubscriptionPriceConfig> getPriceConfigsForOffering(UUID offeringId) {
        List<PriceConfig> priceconfigs = SalesSystemDB.getInstance().getPriceconfigurations();

        List<SubscriptionPriceConfig> configs = new java.util.ArrayList<SubscriptionPriceConfig>();
        for (PriceConfig priceConfig : priceconfigs) {
            if (priceConfig.getOfferingId().equals(offeringId) && priceConfig instanceof SubscriptionPriceConfig) {
                configs.add((SubscriptionPriceConfig) priceConfig);
            }
        }
        return configs;
    }
 */
}
