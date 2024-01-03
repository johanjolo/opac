package se.anjolo.salessystem.salesapp;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import se.anjolo.salessystem.agreement.Agreement;
import se.anjolo.salessystem.checkout.CheckoutService;
import se.anjolo.salessystem.offering.Offering;
import se.anjolo.salessystem.offering.OfferingService;
import se.anjolo.salessystem.pricing.PriceConfig;
import se.anjolo.salessystem.pricing.PriceService;
import se.anjolo.salessystem.pricing.TransactionVolumeServiceDemand;

@RestController
public class SalesController {

    Logger logger = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    private OfferingService offeringService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private CheckoutService checkoutService;
    
/**
 * List uploaded datasets
 * @return
 */
  @GetMapping("/sales/offerings")
  List<Offering> listOfferings() {
    logger.info("Request for all offerings (GET /sales/offerings)");

    return offeringService.getOfferings();
  }

  /**
   * Get price for the selceted offering
   * @param offering id
   * @return
   */
  @GetMapping("/sales/price/{offeringid}")
  PriceConfig getBestPriceForOffering(@PathVariable("offeringid") UUID offeringId, @RequestParam UUID customerId, @RequestParam int transactionVolume) {
    logger.info("Requesting price (GET /sales/price/offeringid)) with id: {} for customer: {} with volume request: {}", offeringId, customerId, transactionVolume);

    TransactionVolumeServiceDemand transactionVolumeServiceDemand = new TransactionVolumeServiceDemand(transactionVolume);
    return priceService.getPrice(offeringId, customerId, transactionVolumeServiceDemand);
  }

/*
 * Checkout
 * @param offering id
 * @requestparam customer id
 * @requestparam price config id
 * @return agreement
 */
  @PostMapping("/sales/checkout/{offeringid}")
  String checkout(@PathVariable("offeringid") UUID offeringId, @RequestParam UUID customerId, @RequestParam UUID priceConfigId) {
    logger.info("Checking out (POST /sales/checkout/{offeringid}) with id: {} for customer: {} with price config: {}", offeringId, customerId, priceConfigId);
  
    PriceConfig priceConfig = priceService.getPriceConfig(priceConfigId);
    Agreement agreement = checkoutService.checkout(offeringId, priceConfig);

    return "Checkout done for offering: " + offeringId + " with agreement id: " + agreement.getAgreementId();
  }



}
