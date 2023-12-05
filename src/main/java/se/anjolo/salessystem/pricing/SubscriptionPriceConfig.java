package se.anjolo.salessystem.pricing;

import java.util.UUID;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


public class SubscriptionPriceConfig extends PriceConfig    {

    @Setter @Getter
    private double price;

    @Setter @Getter
    private PaymentInterval paymentInterval;
    
    // TODO: Support for free trial period
    // nr of free days/weeks/months

    @Setter @Getter
    private double transactionPrice;
    // TODO: Support for transactions and pricing for those
    // nr of free transactions


    public SubscriptionPriceConfig(UUID offeringId, String name, String description, LocalDate validFrom, LocalDate validTo, float price, PaymentInterval paymentInterval) {
        super(offeringId, name, description, validFrom, validTo);
        this.price = price;
        this.paymentInterval = paymentInterval;
    }
    
    
}
